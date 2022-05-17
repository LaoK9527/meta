package com.javastroger.demo.service.serviceimpl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.javastroger.demo.entity.SensitiveWordTreeNode;
import com.javastroger.demo.entity.Words;
import com.javastroger.demo.mapper.WordsMapper;
import com.javastroger.demo.service.BasicModerationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 老K
 */
@Slf4j
@Service
public class BasicModerationServiceImpI implements BasicModerationService {
    
    @Autowired
    private WordsMapper wordsMapper;
    
    @Override
    public boolean moderationText(String content) {
        long start = System.currentTimeMillis();
        List<Words> words = wordsMapper.selectList(Wrappers.<Words>lambdaQuery().eq(Words::getIsDeleted, false));
        List<String> basicWords = words.stream().map(Words::getWord).collect(Collectors.toList());

        // 构造敏感词字典树
        SensitiveWordTreeNode sensitiveWordRootNode = buildRootNode(basicWords);

        // 检查是否包含敏感词
        boolean result = checkSensitiveWord(sensitiveWordRootNode, processContentBeforeCheck(content));

        long end = System.currentTimeMillis();
        if (log.isInfoEnabled()) {
            log.info("Time of filter sensitive words: {}ms", end - start);
        }
        return result;

    }


    public SensitiveWordTreeNode buildRootNode(List<String> basicWords) {
        SensitiveWordTreeNode root = new SensitiveWordTreeNode();
        for (String basicWord : basicWords) {
            SensitiveWordTreeNode current = root;
            int length = basicWord.length();
            for (int i = 0; i < length; i++) {
                char ch = basicWord.charAt(i);
                SensitiveWordTreeNode next = current.getNextNode(ch);
                if (next == null) {
                    next = new SensitiveWordTreeNode();
                    current.putNextNode(ch, next);
                }
                if (i == length - 1) {
                    next.setEnd(true);
                }
                current = next;
            }
        }
        return root;
    }

    public boolean checkSensitiveWord(SensitiveWordTreeNode sensitiveWordRootNode, String content) {
        int length = content.length();
        for (int i = 0; i < length; i++) {
            SensitiveWordTreeNode current = sensitiveWordRootNode;
            for (int j = i; j < length; j++) {
                SensitiveWordTreeNode next = current.getNextNode(content.charAt(j));
                if (next != null) {
                    if (next.getEnd()) {
                        log.warn("LocalSensitiveWord: {}",content.charAt(j));
                        return false;
                    }
                    current = next;
                } else {
                    break;
                }
            }
        }
        return true;
    }

    public String processContentBeforeCheck(String content) {
        return content.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", "").replaceAll("[\\s*|\t|\r|\n]", "");
    }

}

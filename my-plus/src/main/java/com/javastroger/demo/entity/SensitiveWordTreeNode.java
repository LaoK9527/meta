package com.javastroger.demo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 敏感词 字典树 结点
 *
 * @author: Daniel
 * @date: 2021/3/15 17:48
 */
public class SensitiveWordTreeNode {
    /**
     * 敏感词结束标记
     */
    private Boolean end = false;
    /**
     * 存放敏感词的下一个字
     */
    private Map<Character, SensitiveWordTreeNode> nextNodeMap = new HashMap<>();

    public Boolean getEnd() {
        return end;
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }

    public SensitiveWordTreeNode getNextNode(char ch) {
        return this.nextNodeMap.get(ch);
    }

    public void putNextNode(char ch, SensitiveWordTreeNode node) {
        this.nextNodeMap.put(ch, node);
    }
}

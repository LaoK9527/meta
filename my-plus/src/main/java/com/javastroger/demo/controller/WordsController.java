package com.javastroger.demo.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.baomidou.mybatisplus.extension.api.R;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.javastroger.demo.service.BasicModerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author 老K
 */
@RestController
@RequestMapping("words")
public class WordsController {

    @Autowired
    private BasicModerationService basicModerationService;

    @GetMapping("/word")
    public boolean getWords() {
        String checkStr = "kk";
        if (!basicModerationService.moderationText(checkStr)) {
            return false;
        }
        return true;
    }

    @GetMapping("/qzCode")
    @CrossOrigin
    public R getQzCode(HttpServletResponse response) {
        QrConfig config = new QrConfig();
        config.setImg("D:/_DSC3286.JPG");
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        config.setForeColor(new Color(0, 60, 130).getRGB());
        BufferedImage generate = QrCodeUtil.generate("http:baidu.com", config);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            //以JPEG格式向客户端发送

            outputStream = new ByteArrayOutputStream();

            ImageIO.write(generate, "png", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("data:image/png;base64," +
                Base64.getEncoder().encodeToString(outputStream.toByteArray()));
    }
}

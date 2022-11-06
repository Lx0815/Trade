package com.d.tradeserver.web.common.controller;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.utils.ResponseUtils;
import com.d.tradeserver.web.common.response.ResponseCode;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * @author: Ding
 * @date: 2022/10/19 9:24
 * @description:
 * @modify:
 */
@RestController
@RequestMapping("/common")
public class KaptchaController {

    private Producer captchaProducer;

    @Autowired
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    @PostMapping("/captcha")
    public Object getCaptchaImage(HttpServletResponse response, HttpSession session) throws Exception {
        // 将在很久以前到期。
        response.setDateHeader("Expires", 0);
        // 设置标准HTTP1.1无缓存头。
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // 设置IE扩展HTTP1.1无缓存标头（使用addHeader）。
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // 设置标准HTTP1.0无缓存标头。
        response.setHeader("Pragma", "no-cache");
        // 返回jpeg
        response.setContentType("image/jpeg");
        // 为图像创建文本
        String capText = captchaProducer.createText();
        // 将验证码保存到 session 中
        session.setAttribute(Constants.SESSION_KEY_CAPTCHA_LOGIN, capText);
        // 用文本创建图像
        BufferedImage bi = captchaProducer.createImage(capText);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", out);
        return ResponseUtils.createResponse(ResponseCode.SUCCESS, new String(Base64.getEncoder().encode(out.toByteArray())), null);

    }

}

package com.d.tradeserver.common.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Ding
 * @date: 2022/10/19 9:24
 * @description:
 * @modify:
 */

@Controller
@RequestMapping("/common")
public class KaptchaController {

    @GetMapping("/captcha")
    public Object getCaptchaImage() {

    }

}

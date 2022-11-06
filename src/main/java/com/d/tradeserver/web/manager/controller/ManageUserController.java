package com.d.tradeserver.web.manager.controller;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.common.utils.ResponseUtils;
import com.d.tradeserver.pojo.ManageUser;
import com.d.tradeserver.service.manager.ManagerUserService;
import com.d.tradeserver.web.common.annotation.MultiRequestBody;
import com.d.tradeserver.web.common.response.ResponseCode;
import com.d.tradeserver.web.manager.dto.ManageUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.d.tradeserver.web.common.response.ResponseCode.FAIL;
import static com.d.tradeserver.web.common.response.ResponseCode.SUCCESS;

/**
 * @author: Ding
 * @date: 2022/10/16 17:51
 * @description:
 * @modify:
 */

@RestController
@RequestMapping("/manager/manageruser")
public class ManageUserController {

    private ManagerUserService managerUserService;

    @Autowired
    public void setManagerUserService(ManagerUserService managerUserService) {
        this.managerUserService = managerUserService;
    }

    @GetMapping("/check/username/{username}")
    public Object checkUsername(@PathVariable("username") String username) {
        MyPair<Boolean, Object> result = managerUserService.checkUsernameIsExist(username);
        return ResponseUtils.createResponse(SUCCESS, ResponseCode.USERNAME_EXIST.getDescription());
    }

    @PostMapping("/login")
    public Object login(@MultiRequestBody ManageUser user,
                        @MultiRequestBody String captcha,
                        HttpSession session) throws Exception {

        Object captchaObj = session.getAttribute(Constants.SESSION_KEY_CAPTCHA_LOGIN);
        if (!ObjectUtils.nullSafeEquals(captchaObj, captcha)) {
            return ResponseUtils.createResponse(FAIL, ResponseCode.CAPTCHA_ERROR.getDescription());
        }
        MyPair<Boolean, Object> result = managerUserService.login(user);

        session.setAttribute(Constants.SESSION_KEY_CURRENT_USER, result.getValue());
        return ResponseUtils.createResponse(SUCCESS, new ManageUserDTO((ManageUser) result.getValue()), SUCCESS.getDescription());
    }

    @DeleteMapping("/exit")
    public Object exit(HttpSession session) {
        session.removeAttribute(Constants.SESSION_KEY_CURRENT_USER);
        return ResponseUtils.createResponse(SUCCESS, Constants.EMPTY_ARRAY, Constants.EXIT_SUCCESS);
    }
}

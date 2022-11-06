package com.d.tradeserver.web.trade.controller;

import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.common.utils.ResponseUtils;
import com.d.tradeserver.service.trade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.d.tradeserver.web.common.response.ResponseCode.FAIL;
import static com.d.tradeserver.web.common.response.ResponseCode.SUCCESS;

/**
 * @author: Ding
 * @date: 2022/10/27 10:22
 * @description:
 * @modify:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    public Object fetchAllUser() {
        MyPair<Boolean, Object> result = userService.queryAllUser();
        if (result.getKey()) {
            return ResponseUtils.createResponse(SUCCESS, result.getValue(), null);
        } else {
            return ResponseUtils.createResponse(FAIL, null, result.getValue().toString());
        }
    }

}

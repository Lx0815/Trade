package com.d.tradeserver.manager.web.controller;

import com.d.tradeserver.common.pool.impl.ResponseObjectPool;
import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.manager.pojo.ManageUser;
import com.d.tradeserver.manager.service.ManagerUserService;
import com.d.tradeserver.manager.web.dto.ManageUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.d.tradeserver.common.web.response.ResponseCode.*;

/**
 * @author: Ding
 * @date: 2022/10/16 17:51
 * @description:
 * @modify:
 */

@RestController
@RequestMapping("/manager/user")
public class ManageUserController {


    private ResponseObjectPool responseObjectPool;
    @Autowired
    public void setResponseObjectPool(ResponseObjectPool responseObjectPool) {
        this.responseObjectPool = responseObjectPool;
    }

    private ManagerUserService managerUserService;
    @Autowired
    public void setManagerUserService(ManagerUserService managerUserService) {
        this.managerUserService = managerUserService;
    }

    @GetMapping("/check/username/{username}")
    public Object checkUsername(@PathVariable("username") String username) {
        MyPair<Boolean, Object> result = managerUserService.checkUsernameIsExist(username);
        if (result.getKey()) {
            return responseObjectPool.borrowObject()
                    .setCode(SUCCESS)
                    .setMessage("用户名已存在");
        } else {
            return responseObjectPool.borrowObject()
                    .setCode(FAIL)
                    .setMessage("用户名可正常使用");
        }
    }

    @PostMapping("/register")
    public Object register(@RequestBody ManageUser manageUser) throws Exception {
        MyPair<Boolean, Object> result = managerUserService.register(manageUser);
        if (result.getKey()) {
            ManageUserDTO userDTO = new ManageUserDTO((ManageUser) result.getValue());

            return responseObjectPool.borrowObject()
                    .setCode(SUCCESS)
                    .setMessage("注册成功")
                    .setDto(userDTO);
        }

        else {
            return responseObjectPool.borrowObject().setCode(FAIL)
                    .setMessage(result.getValue().toString());
        }
    }

    @PostMapping("/login")
    public Object login(@RequestBody ManageUser user) throws Exception {
        MyPair<Boolean, Object> result = managerUserService.login(user);

        if (result.getKey()) {
            return responseObjectPool.borrowObject()
                    .setCode(SUCCESS)
                    .setDto(new ManageUserDTO((ManageUser) result.getValue()))
                    .setMessage("登录成功");
        } else {
            return responseObjectPool.borrowObject()
                    .setCode(FAIL)
                    .setMessage("登录失败");
        }
    }
}

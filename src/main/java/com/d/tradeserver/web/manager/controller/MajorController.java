package com.d.tradeserver.web.manager.controller;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.common.utils.ResponseUtils;
import com.d.tradeserver.service.manager.MajorService;
import com.d.tradeserver.web.common.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: Ding
 * @date: 2022/10/28 15:22
 * @description:
 * @modify:
 */

@RestController
@RequestMapping("/manager")
public class MajorController {

    private MajorService majorService;

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    @RequestMapping("/majors/{keyword}")
    public Object fetchMajorByKeyword(@PathVariable String keyword) {
        MyPair<Boolean, Object> result = majorService.queryByKeyword(keyword);
        if (result.getKey()) {
            return ResponseUtils.createResponse(ResponseCode.SUCCESS, result.getValue(), "");
        } else {
            return ResponseUtils.createResponse(ResponseCode.NO_DATA, Constants.NO_DATA);
        }
    }

}

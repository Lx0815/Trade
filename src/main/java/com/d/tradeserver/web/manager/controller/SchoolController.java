package com.d.tradeserver.web.manager.controller;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.common.utils.ResponseUtils;
import com.d.tradeserver.service.manager.SchoolService;
import com.d.tradeserver.web.common.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Ding
 * @date: 2022/10/28 14:59
 * @description:
 * @modify:
 */


@RestController
@RequestMapping("/manager")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping("/schools/{keyword}")
    public Object fetchSchoolsByKeyWord(@PathVariable String keyword) {
        MyPair<Boolean, Object> result = schoolService.queryByKeyword(keyword);
        if (result.getKey()) {
            return ResponseUtils.createResponse(ResponseCode.SUCCESS, result.getValue(), Constants.SELECT_SUCCESS);
        } else {
            return ResponseUtils.createResponse(ResponseCode.NO_DATA, Constants.NO_DATA);
        }
    }

}

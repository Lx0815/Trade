package com.d.tradeserver.service.manager.impl;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.common.utils.MyPairUtils;
import com.d.tradeserver.mapper.manager.SchoolMapper;
import com.d.tradeserver.pojo.School;
import com.d.tradeserver.service.manager.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author: Ding
 * @date: 2022/10/28 15:10
 * @description:
 * @modify:
 */


@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {

    private SchoolMapper schoolMapper;

    @Autowired
    public void setSchoolMapper(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    @Override
    public MyPair<Boolean, Object> queryByKeyword(String keyword) {
        List<School> schoolList = schoolMapper.selectByKeyword(keyword);
        if (ObjectUtils.isEmpty(schoolList)) {
            return MyPairUtils.createMyPair(Boolean.FALSE, Constants.NO_DATA);
        } else {
            return MyPairUtils.createMyPair(Boolean.TRUE, schoolList);
        }
    }
}

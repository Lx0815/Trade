package com.d.tradeserver.service.manager.impl;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.utils.MyPair;
import com.d.tradeserver.common.utils.MyPairUtils;
import com.d.tradeserver.mapper.manager.MajorMapper;
import com.d.tradeserver.pojo.Major;
import com.d.tradeserver.service.manager.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author: Ding
 * @date: 2022/10/28 15:24
 * @description:
 * @modify:
 */

@Service
@Transactional
public class MajorServiceImpl implements MajorService {

    private MajorMapper majorMapper;

    @Autowired
    public void setMajorMapper(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    @Override
    public MyPair<Boolean, Object> queryByKeyword(String keyword) {
        List<Major> majorList = majorMapper.selectByKeyword(keyword);
        if (ObjectUtils.isEmpty(majorList)) {
            return MyPairUtils.createMyPair(Boolean.FALSE, Constants.NO_DATA);
        } else {
            return MyPairUtils.createMyPair(Boolean.TRUE, majorList);
        }
    }
}

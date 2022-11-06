package com.d.tradeserver.service.manager;

import com.d.tradeserver.common.utils.MyPair;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public interface MajorService {

    MyPair<Boolean, Object> queryByKeyword(String keyword);

}

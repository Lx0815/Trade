package com.d.tradeserver.common.objectpool;

/**
 * @author: Ding
 * @date: 2022/7/18 14:36
 * @description:
 * @modify:
 */


public interface Pool<A> {

    A borrowObject();

    void returnObject(A a);

}

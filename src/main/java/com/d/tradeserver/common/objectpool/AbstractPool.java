package com.d.tradeserver.common.objectpool;

import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author: Ding
 * @date: 2022/10/17 20:32
 * @description:
 * @modify:
 */


public class AbstractPool<A> implements Pool<A> {

    private final GenericObjectPool<A> pool;

    public AbstractPool(GenericObjectPool<A> pool) {
        this.pool = pool;
    }


    /**
     * 从对象池取出对象
     *
     * @return 返回从对象池取出对象
     */
    @Override
    public A borrowObject() {
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将对象放回对象池
     *
     * @param a 要放回的对象
     */
    @Override
    public void returnObject(A a) {
        pool.returnObject(a);
    }
}

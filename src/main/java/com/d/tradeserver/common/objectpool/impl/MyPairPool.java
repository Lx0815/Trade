package com.d.tradeserver.common.objectpool.impl;

import com.d.tradeserver.common.objectpool.AbstractPool;
import com.d.tradeserver.common.objectpool.factory.PairPooledObjectFactory;
import com.d.tradeserver.common.utils.MyPair;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author: Ding
 * @date: 2022/10/17 20:27
 * @description:
 * @modify:
 */

public class MyPairPool<T, U> extends AbstractPool<MyPair<T, U>> {

    public MyPairPool() {
        this(new GenericObjectPool<>(new PairPooledObjectFactory<>()));
    }

    public MyPairPool(GenericObjectPool<MyPair<T, U>> pairPool) {
        super(pairPool);
    }

    @Override
    public MyPair<T, U> borrowObject() {
        return super.borrowObject();
    }
}

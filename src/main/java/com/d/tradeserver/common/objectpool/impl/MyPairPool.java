package com.d.tradeserver.common.pool.impl;

import com.d.tradeserver.common.pool.AbstractPool;
import com.d.tradeserver.common.pool.factory.PairPooledObjectFactory;
import com.d.tradeserver.common.utils.MyPair;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.stereotype.Component;

/**
 * @author: Ding
 * @date: 2022/10/17 20:27
 * @description:
 * @modify:
 */

@Component
public class MyPairPool<T, U> extends AbstractPool<MyPair<T, U>> {

    public MyPairPool() {
        this(new GenericObjectPool<>(new PairPooledObjectFactory<>()));
    }

    public MyPairPool(GenericObjectPool<MyPair<T, U>> pairPool) {
        super(pairPool);;
    }
}

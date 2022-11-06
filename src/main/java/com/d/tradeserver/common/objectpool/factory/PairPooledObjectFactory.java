package com.d.tradeserver.common.objectpool.factory;

import com.d.tradeserver.common.utils.MyPair;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author: Ding
 * @date: 2022/10/17 19:01
 * @description:
 * @modify:
 */

public class PairPooledObjectFactory<T, U> implements PooledObjectFactory<MyPair<T, U>> {

    @Override
    public void activateObject(PooledObject<MyPair<T, U>> p) {
        p.getObject().clear();
    }

    @Override
    public void destroyObject(PooledObject<MyPair<T, U>> p) {
        p.getObject().clear();
    }

    @Override
    public PooledObject<MyPair<T, U>> makeObject() {
        return new DefaultPooledObject<>(new MyPair<>());
    }

    @Override
    public void passivateObject(PooledObject<MyPair<T, U>> p) {
        p.getObject().clear();
    }

    @Override
    public boolean validateObject(PooledObject<MyPair<T, U>> p) {
        return true;
    }
}

package com.d.tradeserver.common.pool.factory;

import com.d.tradeserver.common.utils.MyPair;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.springframework.stereotype.Component;

/**
 * @author: Ding
 * @date: 2022/10/17 19:01
 * @description:
 * @modify:
 */

@Component
public class PairPooledObjectFactory<T, U> implements PooledObjectFactory<MyPair<T, U>> {

    @Override
    public void activateObject(PooledObject<MyPair<T, U>> p) throws Exception {
        p.getObject().clear();
    }

    @Override
    public void destroyObject(PooledObject<MyPair<T, U>> p) throws Exception {
        p.getObject().clear();
    }

    @Override
    public PooledObject<MyPair<T, U>> makeObject() throws Exception {
        return new DefaultPooledObject<>(new MyPair<>());
    }

    @Override
    public void passivateObject(PooledObject<MyPair<T, U>> p) throws Exception {
        p.getObject().clear();
    }

    @Override
    public boolean validateObject(PooledObject<MyPair<T, U>> p) {
        return true;
    }
}

package com.d.tradeserver.common.pool.impl;

import com.d.tradeserver.common.pool.AbstractPool;
import com.d.tradeserver.common.pool.factory.ResponseObjectPooledObjectFactory;
import com.d.tradeserver.common.web.response.ResponseObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.stereotype.Component;

/**
 * @author: Ding
 * @date: 2022/10/17 20:21
 * @description:
 * @modify:
 */

@Component
public class ResponseObjectPool extends AbstractPool<ResponseObject> {

    public ResponseObjectPool() {
        this(new GenericObjectPool<>(new ResponseObjectPooledObjectFactory()));
    }

    public ResponseObjectPool(GenericObjectPool<ResponseObject> pool) {
        super(pool);
    }
}

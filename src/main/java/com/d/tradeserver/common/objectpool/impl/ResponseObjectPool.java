package com.d.tradeserver.common.objectpool.impl;

import com.d.tradeserver.common.objectpool.AbstractPool;
import com.d.tradeserver.common.objectpool.factory.ResponseObjectPooledObjectFactory;
import com.d.tradeserver.web.common.response.ResponseObject;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author: Ding
 * @date: 2022/10/17 20:21
 * @description:
 * @modify:
 */

public class ResponseObjectPool extends AbstractPool<ResponseObject> {

    public ResponseObjectPool() {
        this(new GenericObjectPool<>(new ResponseObjectPooledObjectFactory()));
    }

    public ResponseObjectPool(GenericObjectPool<ResponseObject> pool) {
        super(pool);
    }
}

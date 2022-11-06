package com.d.tradeserver.common.utils;

import com.d.tradeserver.common.constant.Constants;
import com.d.tradeserver.common.objectpool.impl.ResponseObjectPool;
import com.d.tradeserver.web.common.response.ResponseCode;
import com.d.tradeserver.web.common.response.ResponseObject;
import org.springframework.util.ObjectUtils;

/**
 * @author: Ding
 * @date: 2022/10/27 10:40
 * @description:
 * @modify:
 */


public class ResponseUtils {

    private static final ResponseObjectPool pool = new ResponseObjectPool();
    private static final ThreadLocal<ResponseObject> theadLocal = new ThreadLocal<>();

    private ResponseUtils() {
    }

    public static ResponseObject createResponse(ResponseCode code, String message) {
        return createResponse(code, Constants.EMPTY_ARRAY, message);
    }

    public static ResponseObject createResponse(ResponseCode code, Object data, String message) {
        ResponseObject responseObject = pool.borrowObject().setCode(code).setData(data).setMessage(message);
        theadLocal.set(responseObject);
        return responseObject;
    }

    public static void putBack() {
        ResponseObject responseObject = theadLocal.get();
        if (!ObjectUtils.isEmpty(responseObject)) {
            pool.returnObject(responseObject);
            theadLocal.remove();
        }
    }
}

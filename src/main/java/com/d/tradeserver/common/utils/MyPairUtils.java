package com.d.tradeserver.common.utils;

import com.d.tradeserver.common.objectpool.impl.MyPairPool;
import org.springframework.util.ObjectUtils;

/**
 * @author: Ding
 * @date: 2022/10/27 11:45
 * @description:
 * @modify:
 */

@SuppressWarnings("all")
public class MyPairUtils {

    private static final MyPairPool pool = new MyPairPool();

    private static final ThreadLocal<MyPair> theadLocal = new ThreadLocal<>();

    private MyPairUtils() {
    }

    public static <T, U> MyPair<T, U> createMyPair(T key, U value) {
        MyPair<T, U> myPair = pool.borrowObject().setKeyValue(key, value);
        theadLocal.set(myPair);
        return myPair;
    }

    public static void putBack() {
        MyPair myPair = theadLocal.get();
        if (!ObjectUtils.isEmpty(myPair)) {
            pool.returnObject(myPair);
            theadLocal.remove();
        }
    }

}

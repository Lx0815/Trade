package com.d.tradeserver.commond.utils;

import org.springframework.util.ObjectUtils;

/**
 * @author: Ding
 * @date: 2022/10/17 19:04
 * @description:
 * @modify:
 */

@SuppressWarnings("all")
public class MyPair<T, U> {

    private T key;

    private U value;

    public MyPair() {
    }

    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public MyPair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public void clear() {
        key = null;
        value = null;
    }

    /**
     *
     * @return 获取键
     */
    public T getKey() {
        return key;
    }

    /**
     *
     * @return 获取值
     */
    public U getValue() {
        return value;
    }

    /**
     * 设置键。注意：此键不能为 null
     * @param key 键
     */
    public MyPair<T, U> setKey(T key) {
        if (ObjectUtils.isEmpty(key)) {
            throw new NullPointerException("key 不能为 null");
        }
        this.key = key;
        return this;
    }

    /**
     * 设置值。值可以为 null
     * @param value 值
     */
    public MyPair<T, U> setValue(U value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    public MyPair<T, U> setKeyValue(T key, U value) {
        setKey(key);
        setValue(value);
        return this;
    }
}

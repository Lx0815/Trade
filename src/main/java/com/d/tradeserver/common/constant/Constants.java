package com.d.tradeserver.common.constant;

/**
 * @author: Ding
 * @date: 2022/10/19 11:05
 * @description:
 * @modify:
 */


public class Constants {

    public static final String[] EMPTY_ARRAY = {};

    /*
        session 键
     */
    public static final String SESSION_KEY_CURRENT_USER = "currentUser";
    public static final String SESSION_KEY_CAPTCHA_LOGIN = "loginCaptcha";

    /*
        service 返回内容中的 message
     */
    public static final String NO_DATA = "暂无数据";

    public static final String DATA_EXISTED = "数据已存在";

    public static final String SERVER_EXCEPTION = "服务器异常";

    public static final String CREATE_SUCCESS = "创建成功";

    public static final String CREATE_FAIL = "创建失败";

    public static final String UPDATE_SUCCESS = "更新成功";

    public static final String UPDATE_FAIL = "更新失败";

    public static final String SELECT_SUCCESS = "查询成功";

    public static final String SELECT_FAIL = "查询失败";

    public static final String DELETE_SUCCESS = "删除成功";

    public static final String DELETE_FAIL = "删除失败";

    public static final String EXIT_SUCCESS = "退出登录成功";

    /*
        user 表中的默认数据
     */
    public static final String HEADSHOT_DEFAULT_PATH = "/static/default-headshot.jpg";

    /*
        userDetail 表中的默认数据
     */
    public static final String DEFAULT_PASSWORD = "123456";
    public static final String NOT_LOGIN = "用户未登录";

    private Constants() {
    }
}

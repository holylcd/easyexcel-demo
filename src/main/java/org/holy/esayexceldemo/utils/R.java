package org.holy.esayexceldemo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author holy
 * @email holylcd@foxmail.com
 * @date 2019/4/12
 * @version 1.0.0
 */
public class R extends HashMap {

    private static final long serialVersionUID = -525313397992321713L;

    /**
     * 成功默认 code
     */
    private static final int SUCCESS_DEFAULT_CODE = 0;

    /**
     * 异常默认 code
     */
    private static final int ERROR_DEFAULT_CODE = -1;

    /**
     * 成功默认 msg
     */
    private static String SUCCESS_DEFAULT_MSG = "success";

    /**
     * 异常默认 msg
     */
    private static String ERROR_DEFAULT_MSG = "系统繁忙";

    /**
     * code-key
     */
    private static String CODE_KEY = "code";

    /**
     * msg-key
     */
    private static String MSG_KEY = "msg";

    /**
     * count-key
     */
    private static String COUNT_KEY = "count";

    /**
     * data-key
     */
    private static String DATA_KEY = "data";

    /**
     * page-key
     */
    private static String PAGE_KEY = "page";

    private R() {
        this(4, SUCCESS_DEFAULT_CODE, SUCCESS_DEFAULT_MSG);
    }

    /**
     * 构造 Map
     * @param initialCapacity 初始容量
     * @param code code
     * @param msg msg
     */
    private R(int initialCapacity, int code, String msg) {
        super(initialCapacity);
        super.put(CODE_KEY, code);
        super.put(MSG_KEY, msg);
    }

    /**
     * 成功默认
     * @return
     */
    public static R ok() {
        return ok(SUCCESS_DEFAULT_MSG);
    }

    /**
     * 成功自定义初始容量
     * @param initialCapacity 初始容量
     * @return
     */
    public static R ok(int initialCapacity) {
        R r = new R(initialCapacity, SUCCESS_DEFAULT_CODE, SUCCESS_DEFAULT_MSG);
        return r;
    }

    /**
     * 成功自定义 msg
     * @param msg
     * @return
     */
    public static R ok(String msg) {
        R r = new R(4, SUCCESS_DEFAULT_CODE, msg);
        return r;
    }

    /**
     * 成功带其他数据
     * @param map
     * @return
     */
    public static R ok(Map<String, Object> map) {
        R r = new R(16, SUCCESS_DEFAULT_CODE, SUCCESS_DEFAULT_MSG);
        r.putAll(map);
        return r;
    }

    /**
     * 异常默认
     * @return
     */
    public static R err() {
        return err(ERROR_DEFAULT_MSG);
    }

    /**
     * 异常自定义 msg
     * @param msg
     * @return
     */
    public static R err(String msg) {
        return err(ERROR_DEFAULT_CODE, msg);
    }

    /**
     * 异常自定义 code, msg
     * @param code
     * @param msg
     * @return
     */
    public static R err(int code, String msg) {
        R r = new R(4, code, msg);
        return r;
    }

    /**
     * 补充数据
     * @param key JSON-key
     * @param value JSON-value
     * @return
     */
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 补充总行数
     * @param count
     * @return
     */
    public R count(int count) {
        super.put(COUNT_KEY, count);
        return this;
    }

    /**
     * 补充 data
     * @param data
     * @return
     */
    public R data(Object data) {
        super.put(DATA_KEY, data);
        return this;
    }

    /**
     * 补充 page
     * @param page
     * @return
     */
    public R page(Object page) {
        super.put(PAGE_KEY, page);
        return this;
    }

}
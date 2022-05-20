package com.mawkun.logplatform.common.entity;

public class LogRecordContext {
    public static ThreadLocal<String> threadLocal;

    public static void putEmptySpan() {

    }

    public static void clear() {
        threadLocal.remove();
    }
}

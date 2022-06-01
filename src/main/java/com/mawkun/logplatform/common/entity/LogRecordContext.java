package com.mawkun.logplatform.common.entity;

import java.util.Map;
import java.util.Stack;

public class LogRecordContext {
    private static final InheritableThreadLocal<Stack<Map<String, Object>>> variableMapStack = new InheritableThreadLocal<>();
    public static ThreadLocal<String> threadLocal;

    public static void putEmptySpan() {

    }

    public static Map<String, Object> getVariables() {

    }

    public static void clear() {
        threadLocal.remove();
    }
}

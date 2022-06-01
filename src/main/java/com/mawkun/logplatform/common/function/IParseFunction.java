package com.mawkun.logplatform.common.function;

public interface IParseFunction {
    default boolean executeBefore() {
        return false;
    }

    String functionName();

    String apply(String value);
}

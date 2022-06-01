package com.mawkun.logplatform.common.function;

public interface IFunctionService {
    ParseFunctionFactory parseFunctionFactory = new ParseFunctionFactory();

    String apply(String functionName, String value);
}

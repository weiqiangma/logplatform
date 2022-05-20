package com.mawkun.logplatform.common.entity;

import org.apache.el.lang.EvaluationContext;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.expression.Expression;


import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogRecordExpressionEvaluator extends CachedExpressionEvaluator{
    private Map<ExpressionKey, Expression> expressionCache = new ConcurrentHashMap<>(64);

    private final Map<AnnotatedElementKey, Method> targetMethodCache = new ConcurrentHashMap<>(64);

    public String parseExpression(String conditionExpression, AnnotatedElementKey methodKey, EvaluationContext evalContext) {
        return getExpression(this.expressionCache, methodKey, conditionExpression).getValue(evalContext, String.class);
    }

    private Expression getExpression(Map<ExpressionKey, Expression> expressionCache, AnnotatedElementKey methodKey, String evaluationContext) {
        Expression expression = expressionCache.get(methodKey);
        return null;
    }
}

package com.mawkun.logplatform.common.entity;

import com.mawkun.logplatform.common.annotation.LogRecord;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LogRecordOperationSource<T> {

    public List<T> computeLogRecordOperations(Method method, Class<?> targetClass) {
        List<T> list = new ArrayList<>();
        Annotation[] annotations = method.getAnnotations();
        for (Annotation item : annotations) {
            if (item instanceof LogRecord) {
                list.add((T) item);
            }
        }
        return list;
    }
}

package com.mawkun.logplatform.spring.aspect;

import com.mawkun.logplatform.common.entity.LogRecordContext;
import com.mawkun.logplatform.common.entity.LogRecordOperationSource;
import com.mawkun.logplatform.common.entity.LogRecordOps;
import com.mawkun.logplatform.common.entity.MethodExecuteResult;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

@Aspect
@Component
public class LogAspect {
    private LogRecordOperationSource logRecordOperationSource;

    @Pointcut("@annotation(com.mawkun.core.base.annotation.LogRecord)")
    public void logRecord() {}

    @Around("logRecord()")
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();

        this.execute(joinPoint., target, method, args);
    }

    private Object execute(MethodInvocation invoker, Object target, Method method, Object[] args) throws Throwable {
        Class<?> targetClass = getTargetClass(target);
        Object ret = null;
        MethodExecuteResult methodExecuteResult = new MethodExecuteResult(true, null, "");
        LogRecordContext.putEmptySpan();
        Collection<LogRecordOps> operations = new ArrayList<>();
        Map<String, String> functionNameAndReturnMap = new HashMap<>();
        try {
            operations = logRecordOperationSource.computeLogRecordOperations(method, targetClass);
            List<String> spElTemplates = getBeforeExecuteFunctionTemplate(operations);
            //业务逻辑执行前的自定义函数解析
            functionNameAndReturnMap = processBeforeExecuteFunctionTemplate(spElTemplates, targetClass, method, args);
        } catch (Exception e) {
            System.out.println("log record parse before function exception");
        }
        try {
            ret = invoker.proceed();
        } catch (Exception e) {
            methodExecuteResult = new MethodExecuteResult(false, e, e.getMessage());
        }
        try {
            if (!CollectionUtils.isEmpty(operations)) {
                recordExecute(ret, method, args, operations, targetClass,
                        methodExecuteResult.isSuccess(), methodExecuteResult.getErrorMsg(), functionNameAndReturnMap);
            }
        } catch (Exception t) {
            //记录日志错误不要影响业务
            System.out.println("log record parse exception");
        } finally {
            LogRecordContext.clear();
        }
        if (methodExecuteResult.throwable != null) {
            throw methodExecuteResult.throwable;
        }
        return ret;
    }

    private Class<?> getTargetClass(Object target) {
        return target.getClass();
    }

    private List<String> getBeforeExecuteFunctionTemplate( Collection<LogRecordOps> list) {
        return null;
    }

    private Map<String, String> processBeforeExecuteFunctionTemplate(List<String> spElTemplates, Object targetClass, Method method, Object[] args) {
        return null;
    }

    private void recordExecute(Object ret, Method method, Object[] args, Collection<LogRecordOps> operations, Class<?> targetClass, boolean isSuccess, String errorMsg, Map<String, String> functionNameAndReturnMap) {

    }






}

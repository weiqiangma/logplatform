package com.mawkun.logplatform.spring.aspect;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogRecordAdvisor extends AbstractBeanFactoryPointcutAdvisor implements MethodInterceptor {
    @Override
    public Pointcut getPointcut() {
        return null;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}

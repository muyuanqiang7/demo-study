package com.funi.muyq.demo.study.springsource.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/14 09:23]
 */
@Aspect
public class PerformanceAop {
    // @Pointcut("execution(* com.funi.muyq.demo.study.springsource.aop.PerformanceServiceImpl.perform(..))")
    // public void performanceCut() {
    //
    // }
    @Pointcut("@annotation(PerformanceAnnotation)")
    public void performanceCut() {

    }

    @Before(value = "performanceCut()")
    public void performanceBefore() {
        System.out.println("Performance start...please make your phone silence");
    }

    @AfterReturning(value = "performanceCut()")
    public void performanceAfterReturning() {
        System.out.println("Performance end");
    }


    @Around(value = "performanceCut()")
    public Object performanceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 当连接点是service 实现类的时候使用下面的代码获取方法上的注解
        Method method = joinPoint.getTarget()
                .getClass()
                .getMethod(signature.getMethod().getName(),
                        signature.getMethod().getParameterTypes());
        PerformanceAnnotation performanceAnnotation = method.getAnnotation(PerformanceAnnotation.class);
        System.out.println(method.getName());
        System.out.println(performanceAnnotation.value());
        return joinPoint.proceed();
    }
}

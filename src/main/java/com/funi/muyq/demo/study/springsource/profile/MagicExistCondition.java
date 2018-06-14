package com.funi.muyq.demo.study.springsource.profile;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 10:55]
 */
public class MagicExistCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.out.println(Arrays.toString(conditionContext.getEnvironment().getActiveProfiles()));
        return conditionContext.getEnvironment().getProperty("magic") != null;
    }
}

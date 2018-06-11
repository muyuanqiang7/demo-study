package com.funi.muyq.demo.study;

import com.funi.muyq.demo.study.springsource.beanlifecircle.Person;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/8 11:08]
 */
@ContextConfiguration(locations = "classpath:config/spring-context.xml")
public class PersonTest extends TestCommon {
    @Resource
    private Person person;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void assertPerson() {
        Assert.assertNotNull(person.getHome());
        Assert.assertNotNull(person.getName());
        Assert.assertNotNull(person.getAddress());
        person.printName();
        assertEquals("BeanNameAware\n", systemOutRule.getLog());
    }

    @Test
    public void expression() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end", "!");
        assertEquals("Hello World!", expression.getValue(context));
    }
}

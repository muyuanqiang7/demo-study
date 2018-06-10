package com.funi.muyq.demo.study;

import com.funi.muyq.demo.study.springsource.beanlifecircle.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.annotation.Resource;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/8 11:08]
 */
public class PersonTest extends TestCommon {
    @Resource
    private Person person;

    @Test
    public void assertPerson() {
        Assert.assertNotNull(person.getHome());
        Assert.assertNotNull(person.getName());
        Assert.assertNotNull(person.getAddress());
    }

    @Test
    public void expression() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end", "!");
        Assert.assertEquals("Hello World!", expression.getValue(context));
    }
}

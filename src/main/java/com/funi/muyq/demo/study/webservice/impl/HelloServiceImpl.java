package com.funi.muyq.demo.study.webservice.impl;

import com.funi.muyq.demo.study.webservice.HelloService;

import javax.jws.WebService;

/**
 * @Package: [com.funi.muyq.demo.study.webservice.implHelloServiceImpl]
 * @Description: []
 * @Author: [yuanqiang.mou@funi365.com]
 * @CreateDate: [2018/3/5上午11:35]
 * @UpdateUser: []
 * @UpdateDate: []
 * @UpdateRemark: []
 * @Version: [v1.0]
 */
public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}

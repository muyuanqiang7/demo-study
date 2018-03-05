package com.funi.muyq.demo.study.webservice;

import javax.jws.WebService;

/**
 * @Package: [com.funi.muyq.demo.study.webserviceHelloService]
 * @Description: []
 * @Author: [yuanqiang.mou@funi365.com]
 * @CreateDate: [2018/3/5上午11:34]
 * @UpdateUser: []
 * @UpdateDate: []
 * @UpdateRemark: []
 * @Version: [v1.0]
 */
@WebService
public interface HelloService {
    String sayHello(String name);
}

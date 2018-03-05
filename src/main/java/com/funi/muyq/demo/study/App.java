package com.funi.muyq.demo.study;

import com.funi.muyq.demo.study.webservice.HelloService;
import com.funi.muyq.demo.study.webservice.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;


/**
 * Hello world!
 */

@Slf4j
public class App {
    public static void main(String[] args) {
        //由该类对外发布一个服务, 推荐使用该类
        JaxWsServerFactoryBean server = new JaxWsServerFactoryBean();
        // 或者由父类
        // ServerFactoryBean server = new ServerFactoryBean();
        // 对外提供服务的地址
        server.setAddress("http://localhost:1111/hello");
        // 提供服务的类型,此类必须加上@WebService的注解，不然，该类的实例中所有的方法将不对外暴露，但也不报错
        server.setServiceClass(HelloService.class);
        // 提供服务的实例
        server.setServiceBean(new HelloServiceImpl());
        // 添加请求消息拦截器
        // server.getInInterceptors().add(new LoggingInInterceptor());
        // 添加响应消息拦截器
        // server.getOutInterceptors().add(new LoggingOutInterceptor());
        // 发布服务相当于JDK的 EndPoint.publish()
        server.create();
        // HelloServiceImpl helloService = new HelloServiceImpl();
        // EndpointImpl jaxWsEndpoint = (EndpointImpl) javax.xml.ws.Endpoint.publish("http://127.0.0.1:8080/hello", helloService);
        // Endpoint cxfEndpoint = jaxWsEndpoint.getServer().getEndpoint();
        log.info("Web Service暴露成功！");
    }
}

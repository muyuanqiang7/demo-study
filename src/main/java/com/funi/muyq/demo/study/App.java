package com.funi.muyq.demo.study;

import com.funi.muyq.demo.study.webservice.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HelloServiceImpl helloService = new HelloServiceImpl();
        Endpoint.publish("http://127.0.0.1:8080/hello", helloService);
        System.out.println("Web Service暴露成功！");
    }
}

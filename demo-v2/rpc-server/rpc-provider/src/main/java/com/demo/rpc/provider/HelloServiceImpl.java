package com.demo.rpc.provider;

import com.demo.rpc.server.api.IHelloService;

public class HelloServiceImpl implements IHelloService {

    public String sayHello(String name, String content) {
        System.out.println("request parameters: " + name + " " + content);
        return "Hello " + name + " " + content;
    }

    public void buy(String name) {
        System.out.println("request in: " + name + " 要买东西");
    }
}
package com.demo.rpc.server.api;

public interface IHelloService {

    String sayHello(String name, String content);

    void buy(String name);

}
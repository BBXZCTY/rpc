package com.demo.rpc.client;

import com.demo.rpc.server.api.IHelloService;
import com.demo.rpc.server.api.RpcRequest;

public class Client {

    public static void main(String[] args) {
        RpcNetTransport rpcNetTransport = new RpcNetTransport("localhost", 8080);
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName("com.demo.rpc.provider.HelloServiceImpl");
        rpcRequest.setMethodName("sayHello");
        Object[] parames = new Object[]{"zhangsan", "饭否"};
        rpcRequest.setArguments(parames);
        Object result = rpcNetTransport.send(rpcRequest);
        System.out.println(result);
    }
}
package com.demo.rpc.client_v1;

import com.demo.rpc.server.api.RpcRequest;

public class Client {

    public static void main(String[] args) {
        RpcNetTransport rpcNetTransport = new RpcNetTransport("localhost", 8080);
        RpcRequest rpcRequest = new RpcRequest();
        // 传接口或者实现类都可以，都可以获得相应的Class对象，然后再获得相同的Method
//        rpcRequest.setClassName("com.demo.rpc.provider.HelloServiceImpl");
        rpcRequest.setClassName("com.demo.rpc.server.api.IHelloService");
        rpcRequest.setMethodName("sayHello");
        Object[] parames = new Object[]{"zhangsan", "饭否"};
        rpcRequest.setArguments(parames);
        Object result = rpcNetTransport.send(rpcRequest);
        System.out.println(result);
    }
}
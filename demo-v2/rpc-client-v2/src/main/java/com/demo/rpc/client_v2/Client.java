package com.demo.rpc.client_v2;

import com.demo.rpc.server.api.IHelloService;

public class Client {

    public static void main(String[] args) {
        IHelloService helloService = RpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
        // {$Proxy0@576}"null"
        System.out.println("helloService=" + helloService);
        // 此时返回结果不是 "Hello " + name + " " + content;
        // 而是 "这里才是真正的服务端执行结果-->Hello zhangsan 饭否"
        // 说明 helloService.sayHello 是个"假"调用
        String result = helloService.sayHello("zhangsan", "饭否");
        System.out.println("main函数调用返回结果：" + result);
    }
}
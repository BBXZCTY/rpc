package com.demo.rpc.client_v2.dynamic_demo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo_v2 {

    public static void main(String[] args) {

        IUserService_v2 userService_v2 = DynamicProxyDemo_v2.clientProxy(IUserService_v2.class);
        // {$Proxy0@576}"666"
        System.out.println("userService_v2=" + userService_v2);

        System.out.println("触发。。。");
        // "666"
        String say = userService_v2.say("zhangsan", "饭否");
        System.out.println("say=" + say);


    }

    private Class clazz;

    public DynamicProxyDemo_v2(Class clazz) {
        this.clazz = clazz;
    }


    public static  <T> T clientProxy(Class<T> interfaceCls) {
        System.out.println("clientProxy start...");
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class[]{interfaceCls}, new MyInvocationHandler());
    }

}

class MyInvocationHandler implements InvocationHandler {

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke start...");
        before();
        System.out.println("method=" + method);
        after();
        return "666";
    }
}

interface IUserService_v2 {
    String say(String name, String content);
}

class UserServiceImpl_v2 implements IUserService_v2 {

    public String say(String name, String content) {
        System.out.println("我是" + name + "我要" + content);
        return "回答正确";
    }
}

interface IOrderService_v2 {
    void buy();
}

class OrderServiceImpl_v2 implements IOrderService_v2 {

    public void buy() {
        System.out.println("买东西");
    }
}
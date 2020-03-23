package com.demo.rpc.client_v2.dynamic_demo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo implements InvocationHandler {

    public static void main(String[] args) {
        IUserService userService = (IUserService) new DynamicProxyDemo(new UserServiceImpl()).bind();
        userService.say("张三", "去超市");

        System.out.println("============");

        IOrderService orderService = (IOrderService) new DynamicProxyDemo(new OrderServiceImpl()).bind();
        System.out.println(orderService);
        orderService.buy();

        System.out.println("============");

        Object bind = new DynamicProxyDemo(IUserService.class).bind();
        System.out.println(bind);

    }

    private Object target;

    public DynamicProxyDemo(Object target) {
        this.target = target;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    public Object bind() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }
}

interface IUserService {
    void say(String name, String content);
}

class UserServiceImpl implements IUserService {

    public void say(String name, String content) {
        System.out.println("我是" + name + "我要" + content);
    }
}

interface IOrderService {
    void buy();
}

class OrderServiceImpl implements IOrderService {

    public void buy() {
        System.out.println("买东西");
    }
}
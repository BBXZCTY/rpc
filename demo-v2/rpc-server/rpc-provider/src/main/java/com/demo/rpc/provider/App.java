package com.demo.rpc.provider;

public class App {

    public static void main(String[] args) {
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(8080, new HelloServiceImpl());
    }
}
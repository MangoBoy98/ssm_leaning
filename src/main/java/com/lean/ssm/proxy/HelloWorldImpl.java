package com.lean.ssm.proxy;

/**
 * 实现接口,并重写其中的抽象方法
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.err.println("Hello World");
    }
}

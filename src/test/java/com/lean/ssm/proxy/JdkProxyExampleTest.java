package com.lean.ssm.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

public class JdkProxyExampleTest {

    @Test
    public void testJdkProxy(){
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        //绑定关系,因为挂在接口HelloWorld下,所以声明代理对象HelloWorld proxy
        HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        //注意,此时HelloWorld对象已经是一个代理对象,它会进入代理的逻辑方法invoke里面
        proxy.sayHelloWorld();
    }

}
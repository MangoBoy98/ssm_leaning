package com.lean.ssm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理逻辑类
 */
public class JdkProxyExample implements InvocationHandler {

    //真实对象
    private Object target = null;

    /**
     * 建立代理对象和真实对象的代理关系,并返回代理对象
     * @param target 真实对象
     * @return  代理对象
     */
    public Object bind(Object target){
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        return proxy;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 当前方法参数
     * @return  代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.err.println("进入代理逻辑方法");
        System.err.println("在调度真实对象之前的服务");

        Object obj = method.invoke(target, args);

        System.err.println("在调度真实对象之后的服务");

        return obj;
    }
}

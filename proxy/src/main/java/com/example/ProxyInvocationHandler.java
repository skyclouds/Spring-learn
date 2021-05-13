package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler{
    //被代理的接口
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    } 

    //生成得到代理类
    public Object getProxy(){
        return Proxy .newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    } 

    //处理代理实例,并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[Debug]"+"使用了"+method.getName()+"方法");
        Object reslut=method.invoke(target,args);
        return reslut;
    }
}

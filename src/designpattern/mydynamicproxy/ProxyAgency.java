package designpattern.mydynamicproxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class ProxyAgency implements MyInvocationHandler{

    private Object target;

    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();

        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target,args);
        after();
        return null;
    }

    private void before(){
        System.out.println("do something");
        System.out.println("get started !");
    }

    private void after(){
        System.out.println("done!");
    }
}

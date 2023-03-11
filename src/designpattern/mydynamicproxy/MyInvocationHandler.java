package designpattern.mydynamicproxy;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    /**
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}

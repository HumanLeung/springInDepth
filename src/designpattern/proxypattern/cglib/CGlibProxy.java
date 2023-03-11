package designpattern.proxypattern.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class CGlibProxy implements MethodInterceptor {

    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
     before();
     Object obj = methodProxy.invokeSuper(o,objects);
     after();
     return obj;
    }

    private void before(){
        System.out.println("do something");
        System.out.println("get started !");
    }

    private void after(){
        System.out.println("done!");
    }
}

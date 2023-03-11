package designpattern.proxypattern.dynamicproxy;

import designpattern.proxypattern.staticproxy.Person;

/**
 * @author Administrator
 */
public class Client implements Person {
    @Override
    public void doBusiness() {
        System.out.println("I'm busy right now");
    }
}

package designpattern.mydynamicproxy;

import designpattern.proxypattern.dynamicproxy.Client;
import designpattern.proxypattern.staticproxy.Person;

public class Main {

    public static void main(String[] args) {
        Person obj;
        try {
            obj = (Person) new ProxyAgency().getInstance(new Client());
            System.out.println(obj.getClass());
            obj.doBusiness();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

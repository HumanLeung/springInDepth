package designpattern.proxypattern.dynamicproxy;

import designpattern.proxypattern.staticproxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Person obj = (Person)new ProxyBroker().getInstance(new Client());
        obj.doBusiness();

       byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});

        FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
        os.write(bytes);
        os.close();
    }
}

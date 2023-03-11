package designpattern.proxypattern.cglib;

/**
 * @author Administrator
 */
public class CglibTest {
    public static void main(String[] args) {
        Customer obj = (Customer) new CGlibProxy().getInstance(Customer.class);
        obj.doBusiness();
    }
}

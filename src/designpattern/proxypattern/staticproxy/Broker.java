package designpattern.proxypattern.staticproxy;

/**
 * @author Administrator
 */
public class Broker implements Person{
    @Override
    public void doBusiness() {
        //broker do real thing
        System.out.println("someone do for me");
    }
}

package designpattern.proxypattern.staticproxy;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client(new Broker());
        client.doBusiness();
    }
}

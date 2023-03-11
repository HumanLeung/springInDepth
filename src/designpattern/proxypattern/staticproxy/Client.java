package designpattern.proxypattern.staticproxy;

/**
 * @author Administrator
 */
public class Client {
  private final Broker broker;
  public Client(Broker broker){
      this.broker = broker;
  }

  public void doBusiness(){
      System.out.println("Client's business");
      this.broker.doBusiness();
      System.out.println("business's done");
  }
}

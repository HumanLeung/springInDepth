package designpattern.singleton;

/**
 * @author Administrator
 */
public class LazyDoubleCheckSingleton {
    private static volatile LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){
      if (lazy == null){
          synchronized (LazyDoubleCheckSingleton.class){
              if (lazy == null){
                  lazy = new LazyDoubleCheckSingleton();
                  //1.分配内存给这个对象
                  //2.初始化对象
                  //3.设置lazy指向刚分配的内存地址
              }
          }
      }
      return lazy;
    }

    public void print(){
        System.out.println();
    }
}

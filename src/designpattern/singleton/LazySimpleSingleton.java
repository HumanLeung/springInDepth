package designpattern.singleton;

/**
 * test
 * @author Administrator
 */
public class LazySimpleSingleton {
    private LazySimpleSingleton(){}
    private static LazySimpleSingleton lazy = null;
    public static LazySimpleSingleton getInstance(){
        if (lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }

    public synchronized static LazySimpleSingleton getInstanceInSync(){
        if (lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}

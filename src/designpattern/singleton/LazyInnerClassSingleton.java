package designpattern.singleton;

/**
 * @author Administrator
 */

//静态内部类的方式兼顾饿汉式单例模式的内存浪费问题和synchronized
//完美地屏蔽了这两个缺点
public class LazyInnerClassSingleton {
    /**
     * 使用LazyInnerClassSingleton时候，默认会先初始化内部类
     * 如果没使用，则内部类是不加载
     */
    private LazyInnerClassSingleton(){}

    public static LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

    public void print(){
        System.out.println();
    }

}

package designpattern.singleton;

/**
 * @author Administrator
 */
public class HungerySingleton {

    //先静态、后动态
    //先属性、后方法
    //先上后下

    /**
     *asd
     */
    private static final HungerySingleton HUNGERY_SINGLETON = new HungerySingleton();

    private HungerySingleton(){}

    public static HungerySingleton getHungerySingleton(){
        return HUNGERY_SINGLETON;
    }
}

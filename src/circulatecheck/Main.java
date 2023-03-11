package circulatecheck;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> keyList = new ArrayList<>();
    public static void main(String[] args) {
       new Main().test1();
    }

    public void test1(){
        System.out.println("hahaha");
        keyList.add("test1");
        test2();
    }

    public void test2() {
        if (!keyList.contains("test1")) {
            System.out.println("heheheh");
            test1();
        }else{
            keyList.clear();
        }
    }
}

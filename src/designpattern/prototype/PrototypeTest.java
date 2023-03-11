package designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {

    public static void main(String[] args) {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(18);
        concretePrototypeA.setName("Prototype");
        List<String> hobbits = new ArrayList<>();
        concretePrototypeA.setHobbies(hobbits);
        System.out.println(concretePrototypeA);

        Client client = new Client(concretePrototypeA);
        ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println(concretePrototypeClone);

        System.out.println("克隆对象中的引用类型地址值: " + concretePrototypeClone.getHobbies());
        System.out.println("原对象中的引用类型地址值: " + concretePrototypeClone.getHobbies());
        System.out.println("对象地址比较："+(concretePrototypeClone.getHobbies() == concretePrototypeA.getHobbies()));
    }
}

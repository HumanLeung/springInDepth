package designpattern.factory.abstractfactory;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        JavaCourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}

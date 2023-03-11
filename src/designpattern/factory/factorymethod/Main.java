package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.entity.ICourse;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();
    }
}

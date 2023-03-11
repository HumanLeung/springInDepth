package designpattern.factory;

import designpattern.factory.simplefactory.entity.CourseFactory;
import designpattern.factory.simplefactory.entity.ICourse;
import designpattern.factory.simplefactory.entity.JavaCourse;

public class Main {
    public static void main(String[] args) {
        ICourse course = new JavaCourse();
        course.record();

        //简单工厂模式
        CourseFactory factory = new CourseFactory();
        ICourse javaCourse = factory.create("java");
        javaCourse.record();

        //通过反射
        CourseFactory factoryReflect = new CourseFactory();
        ICourse courseReflect = factoryReflect.createWithReflect(JavaCourse.class.getName());
        courseReflect.record();

        CourseFactory factoryClazz = new CourseFactory();
        ICourse courseClazz = factoryClazz.createWithReflectBravo(JavaCourse.class);
        courseClazz.record();
    }
}

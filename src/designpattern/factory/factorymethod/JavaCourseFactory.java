package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.entity.ICourse;
import designpattern.factory.simplefactory.entity.JavaCourse;

/**
 * @author Administrator
 */
public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}

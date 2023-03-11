package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.entity.ICourse;
import designpattern.factory.simplefactory.entity.PythonCourse;

/**
 * @author Administrator
 */
public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}

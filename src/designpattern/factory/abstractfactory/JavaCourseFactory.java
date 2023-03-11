package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.entity.INote;
import designpattern.factory.abstractfactory.entity.IVideo;
import designpattern.factory.abstractfactory.entity.JavaNote;
import designpattern.factory.abstractfactory.entity.JavaVideo;

/**
 * @author Administrator
 */
public class JavaCourseFactory implements CourseFactory{
    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}

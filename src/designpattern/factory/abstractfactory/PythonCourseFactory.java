package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.entity.INote;
import designpattern.factory.abstractfactory.entity.IVideo;
import designpattern.factory.abstractfactory.entity.PythonNote;
import designpattern.factory.abstractfactory.entity.PythonVideo;

public class PythonCourseFactory implements CourseFactory{
    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}

package designpattern.factory.abstractfactory;

import designpattern.factory.abstractfactory.entity.INote;
import designpattern.factory.abstractfactory.entity.IVideo;

public interface CourseFactory {
    INote createNote();
    IVideo createVideo();
}

package designpattern.factory.simplefactory.entity;

public class PythonCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("录制 Python 课程");
    }
}

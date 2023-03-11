package designpattern.factory.abstractfactory.entity;

/**
 * @author Administrator
 */
public class PythonVideo implements IVideo{
    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}

package designpattern.factory.abstractfactory.entity;

/**
 * @author Administrator
 */
public class JavaNote implements INote{
    @Override
    public void edit() {
        System.out.println("编写Java笔记");
    }
}

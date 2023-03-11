package designpattern.factory.simplefactory.entity;

public class CourseFactory {
    public ICourse create(String name){
        if ("java".equals(name)){
           return new JavaCourse();
        }else if("python".equals(name)){
            return new PythonCourse();
        }else{
            return null;
        }
    }

    //通过反射
    public ICourse createWithReflect(String className) {
        try{
          if (! (null == className || "".equals(className))) {
              return (ICourse) Class.forName(className).newInstance();
          }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ICourse createWithReflectBravo(Class<? extends ICourse> clazz) {
        try{
           if (null != clazz){
               return clazz.newInstance();
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package designpattern.mydynamicproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Administrator
 */
public class MyClassLoader extends ClassLoader {
    private File classPathFile;
    public MyClassLoader(){
        String classPath = Objects.requireNonNull(MyClassLoader.class.getResource("")).getPath();
        this.classPathFile = new File(classPath);
    }

    protected Class<?> findClass(String name) {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null){
            File classFile = new File(classPathFile,name.replaceAll("\\.","/") + ".class");
            if (classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;

                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte [] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                }catch (Exception e){
                  e.printStackTrace();
                }finally {
                    if (null != in){
                        try{
                            in.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if (out != null){
                        try {
                            out.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

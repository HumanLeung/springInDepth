package designpattern.mydynamicproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class MyProxy {
    public static final String LN = System.lineSeparator();
    public static Object newProxyInstance(MyClassLoader myClassLoader,Class<?> [] interfaces, MyInvocationHandler h){
        try{
            String src = generateSrc(interfaces);
            System.out.println(src);

            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manage.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manage,null,null,null,iterable);
            task.call();
            manage.close();

            Class proxyClass = myClassLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();

            return c.newInstance();
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

   private static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append("package designpattern.mydynamicproxy;" + LN);
        sb.append("import designpattern.proxypattern.staticproxy.Person;" + LN);
        sb.append("import java.lang.reflect.*;" + LN);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{"+ LN);
           sb.append("MyInvocationHandler h;" + LN);
           sb.append("public $Proxy0(MyInvocationHandler h) { " + LN);
           sb.append("this.h = h;");
        sb.append("}" + LN);
        for (Method m : interfaces[0].getMethods()){
            Class<?>[] params = m.getParameterTypes();
            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++){
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type = " " + paramName);
                paramValues.append(paramNames);
                paramClasses.append(clazz.getName() + ".class");

                if (i > 0 && i < params.length - 1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + " ) {" + LN);
            sb.append("try{" + LN);
            sb.append("Method m =" + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[] {" + paramClasses.toString() + "});" + LN);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{"+ paramValues + "})",m.getReturnType()) + ";" + LN);
            sb.append("} catch(Error _ex) { }");
            sb.append("catch(Throwable e) {" + LN);
            sb.append("throw new UndeclaredThrowableException(e);" + LN);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
       sb.append("}" + LN);
        return sb.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<>();
    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if (mappings.containsKey(returnClass)){
            return "return 0;";
        }else if (returnClass == void.class){
            return "";
        }else{
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass){
        if (mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }
    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}

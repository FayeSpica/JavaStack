package jre.jvm;

import java.io.*;

/**
 * 自定义文件系统类加载器
 * */
public class FileSysytemClassLoader extends ClassLoader{
    // User.class
    private String rootDir="/Users/lxx/git/JavaStack/src/main/java/jre/jvm";

    public FileSysytemClassLoader(){

    }

    public FileSysytemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    public FileSysytemClassLoader(ClassLoader parent, String rootDir) {
        super(parent);
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class<?> c =findLoadedClass(name);

        if(c!=null){
            return c;
        }

        //ClassLoader parent = this.getParent();
        //parent.loadClass(name);

        if(c!=null){
            return c;
        }

        byte[] classData = getClassData(name);
        if(classData==null){
            throw new ClassNotFoundException();
        }

        c = defineClass(name,classData,0,classData.length);

        return c;
    }

    private byte[] getClassData(String className){
        String url = rootDir+"/"+className.replace('.','/')+".class";
        InputStream is=null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(url);
            int tmp;
            byte[] buffer = new byte[5*1024];

            while ((tmp=is.read(buffer))!=-1){
                baos.write(buffer,0,tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos!=null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //

        return baos.toByteArray();
    }
}

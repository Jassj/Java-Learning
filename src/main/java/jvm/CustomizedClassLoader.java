package jvm;

import java.io.*;

/**
 * description
 * 自定义类加载器
 * @author yuanjie 2020/03/27 11:14
 */
public class CustomizedClassLoader extends ClassLoader{

    private final static String CUSTOM_CLASSLOADER_PATH = "D:\\classLoaderTest\\lib";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] result = getClassFromCustomPath(name);
        if(result == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, result, 0, result.length);
        }

    }

    // 可对加密类进行解密
    // 读取指定路径下的class文件并转换成二进制流
    private byte[] getClassFromCustomPath(String name) {
        String path = CUSTOM_CLASSLOADER_PATH + File.separator + name + ".class";
        InputStream in;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(path);
            byte[] buffer = new byte[1024 * 4];
            int n;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return out.toByteArray();
    }

    public static void main(String[] args) {
        CustomizedClassLoader customizedClassLoader = new CustomizedClassLoader();
        try {
            Class<?> clazz = Class.forName("Custom", true, customizedClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader()); // jvm.CustomizedClassLoader@7f31245a
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



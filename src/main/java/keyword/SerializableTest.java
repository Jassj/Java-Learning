package keyword;

import java.io.*;

/**
 * description
 * 序列化接口
 * @author yuanjie 2020/03/29 23:06
 */
public class SerializableTest implements Serializable {
    private String userName;
    transient private String password;

    public SerializableTest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "SerializableTest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化一个对象(存储到一个文件)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E://user.text"));
        oos.writeObject("Save a object:\n");
        oos.writeObject(new SerializableTest("Bruce", "123456")); // Exception in thread "main" java.io.NotSerializableException: keyword.SerializableTest
        oos.close();

        // 反序列化,将该对象恢复(存储到一个文件)
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E://user.text"));
        String s = (String)ois.readObject();
        SerializableTest p = (SerializableTest)ois.readObject();
        System.out.println(p);
    }
}

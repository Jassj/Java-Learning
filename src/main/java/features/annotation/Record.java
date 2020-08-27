package features.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Record {
    @Field_Method_Parameter_Annotation(describe = "编号", type = int.class)
    public int id;
    @Field_Method_Parameter_Annotation(describe = "姓名", type = int.class)
    public String name;

    @Constructor_Annotation()
    public Record() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Field_Method_Parameter_Annotation(describe = "获取姓名方法")
    public String getName() {
        return name;
    }

    @Field_Method_Parameter_Annotation(describe = "设置姓名方法")
    public void setName(String name) {
        this.name = name;
    }

    @Constructor_Annotation(value = "立即初始化构造方法")
    private Record(
            @Field_Method_Parameter_Annotation(describe = "编号", type = int.class) int id,
            @Field_Method_Parameter_Annotation(describe = "姓名", type = String.class) String name) {
        this.id = id;
        this.name = name;
    }

    public static void annotationRetainedForReflective() throws Exception {
        Class<Record> myClass = Record.class;
        Field myField = myClass.getField("id");
        Field_Method_Parameter_Annotation annotationOnField = myField.getAnnotation(Field_Method_Parameter_Annotation.class);
        System.out.println(annotationOnField.describe());
        Method myMethod1 = myClass.getMethod("getName", null);
        Field_Method_Parameter_Annotation annotationOnMethod1 = myMethod1.getAnnotation(Field_Method_Parameter_Annotation.class);
        System.out.println(annotationOnMethod1.describe());
        Method myMethod2 = myClass.getMethod("setName", String.class);
        Field_Method_Parameter_Annotation annotationOnMethod2 = myMethod2.getAnnotation(Field_Method_Parameter_Annotation.class);
        System.out.println(annotationOnMethod2.describe());
    }

    public static void main(String[] args) throws Exception{
        annotationRetainedForReflective();
    }

}

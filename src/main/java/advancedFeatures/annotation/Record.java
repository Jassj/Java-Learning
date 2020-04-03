package advancedFeatures.annotation;

public class Record {
    @Field_Method_Parameter_Annotation(describe = "编号", type = int.class)
    int id;
    @Field_Method_Parameter_Annotation(describe = "姓名", type = int.class)
    String name;

    @Constructor_Annotation()
    public Record() {
    }

    @Constructor_Annotation(value = "立即初始化构造方法")
    private Record(
            @Field_Method_Parameter_Annotation(describe = "编号", type = int.class) int id,
            @Field_Method_Parameter_Annotation(describe = "姓名", type = String.class) String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
//        Record record = new Record( 1, "李四");
    }
}

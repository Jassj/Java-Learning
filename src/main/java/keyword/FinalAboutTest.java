package keyword;

/**
 * description
 * final & finally & finalize
 * @author yuanjie 2020/03/28 16:55
 */
// 无法继承final修饰的类，Cannot inherit from final 'keyword.FinalClass'
public class FinalAboutTest /*extends  FinalClass*/{
    final float PI = 3.14f; // final修饰的变量需要初始化

//    public void setPI(float pi) {
//        this.PI = pi; // final修饰的变量不能重新复制
//    }

    final void print() {
        System.out.println("this method can not be override");
    }


    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Method Ending");
        }
    }
}

class FinalDemo extends FinalAboutTest {

//    @Override
//    void print() { // final 修饰的方法不能被重写
//        System.out.println("i want to override this method");
//    }

}


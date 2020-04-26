package keyword;

/**
 * description
 * volatile: 保证并发场景的可见性和有序性
 * @author yuanjie 2020/04/13 15:36
 */
public class VolatileTest {
    public volatile static int i;

    public static void main(String[] args) {
        int a = 3;
        i = a + 1;
        int c = i;
        while(!flag){

        }
    }

    volatile static boolean flag = false;


    public void setFlag() {
        flag = true;
    }

}

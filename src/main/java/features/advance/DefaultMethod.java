package features.advance;

/**
 * 默认方法
 */
public class DefaultMethod {

    public interface Vehicle {
        default void print(){
            System.out.println("我是一辆车!");
        }
        // 静态方法
        static void blowHorn(){
            System.out.println("按喇叭!!!");
        }
    }

    interface FourWheeler {
        default void print(){
            System.out.println("我是一辆四轮车!");
        }
    }

    static class Car implements Vehicle, FourWheeler {
        public void print(){
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.blowHorn();
            System.out.println("我是一辆汽车!");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.print();
    }

}
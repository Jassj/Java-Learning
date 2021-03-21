package features.advance;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    static class Car {
        //Supplier是jdk1.8的接口，这里和lamda一起使用了
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }

    }

    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final Car car1 = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car, car1);

        cars.forEach(Car::collide);
        cars.forEach(Car::repair);

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }

}
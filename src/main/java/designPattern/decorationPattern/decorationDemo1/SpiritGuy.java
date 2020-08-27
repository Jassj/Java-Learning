package designPattern.decorationPattern.decorationDemo1;

public class SpiritGuy implements Person {

    @Override
    public void show() {
//        违背单一职责原则: 类承担的职责尽量单一, 避免过多耦合
//        showTops();
//        showBottoms();
        System.out.println("my clothing style is cool!");
    }

//    public void showTops() {
//        System.out.println("my TShirt is cool!");
//    }

//    public void showBottoms() {
//        System.out.println("my BigTrouser is cool!");
//    }

}

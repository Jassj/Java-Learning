package designPattern.decorationPattern.decorationDemo1;

public class Decorate {

    public static void main(String[] args) {
        SpiritGuy spiritGuy = new SpiritGuy();
        Finery finery2 = new BigTrouser();
        finery2.decorate(spiritGuy);
        Finery finery1 = new TShirts();
        finery1.decorate(finery1);
        finery2.show();
    }

}

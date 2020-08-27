package designPattern.decorationPattern.inheritionDemo;

import designPattern.decorationPattern.decorationDemo1.SpiritGuy;

public class Tops extends SpiritGuy {

    @Override
    public void show() {
        System.out.println("my tops is cool!");
        super.show();
    }

}

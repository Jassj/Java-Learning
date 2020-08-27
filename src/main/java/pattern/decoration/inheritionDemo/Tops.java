package pattern.decoration.inheritionDemo;

import pattern.decoration.decorationDemo1.SpiritGuy;

public class Tops extends SpiritGuy {

    @Override
    public void show() {
        System.out.println("my tops is cool!");
        super.show();
    }

}

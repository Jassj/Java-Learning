package pattern.decoration.decorationDemo1;

public class BigTrouser extends Finery {

    @Override
    public void show() {
        System.out.println("wear BigTrouser!");
        enhance();
        super.show();
    }

    public void enhance() {
        System.out.println("it's Hip hop style!");
    }

}

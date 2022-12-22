package task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        makeSmth();
    }

    private static void makeSmth() {
        var cats = new ArrayList<ActiveCat>();
        cats.add(new ActiveCat(ActiveCat::drinkMilk));
        cats.add(new ActiveCat(() -> ActiveCat.eat()));
        cats.add(new ActiveCat(ActiveCat::sleep));
        cats.add(new ActiveCat(ActiveCat::play));
        cats.add(new ActiveCat(ActiveCat::watchTV));
        cats.add(new ActiveCat(ActiveCat::jump));

        cats.forEach(ActiveCat::doAction);
    }
}

import task1.Cat;
import task1.Printer;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        var cats = Cat.makeCats(10);
        System.out.println("|________Before sorting___________________|");
        Printer.print(cats);

        cats.sort(Cat::byBreed);
        System.out.println("|________Sorting by breed___________________|");
        Printer.print(cats);

        cats.sort(Comparator.comparing(Cat::getName).thenComparing(Cat::getAge));
        System.out.println("|________Sorting by name and age___________|");
        Printer.print(cats);

        System.out.println("|______After removing by color(Tabby)______|");
        cats.removeIf(cat -> cat.getColor() == Cat.Color.TABBY);
        Printer.print(cats);

        System.out.println("|_After removing by name(equal to 5 chars)_|");
        cats.removeIf(cat -> cat.getName().length() == 5);
        Printer.print(cats);
    }
}
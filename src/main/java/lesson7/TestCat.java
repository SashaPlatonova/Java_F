package lesson7;

public class TestCat {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat cats [] = new Cat[5];
        cats[0] = new Cat("Barsik", 10);
        cats[1] = new Cat("Mars", 10);
        cats[2] = new Cat("Pushok", 30);
        cats[3] = new Cat("Bantik", 40);
        cats[4] = new Cat("Snow", 25);

        for (int i = 0; i < 5; i++) {
            cats[i].eat(plate);
            System.out.println(cats[i].getName() + ": " + cats[i].isSatiety());
        }

        plate.addFood(100);
        plate.info();


    }
}
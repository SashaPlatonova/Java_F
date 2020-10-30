package lesson6;

public class TestAnimal {

    public static void main(String[] args) {
        Barriers river = new Barriers("river", 20, 's');
        Barriers wall = new Barriers("wall", 2, 'j');
        Barriers road = new Barriers("road", 400, 'r');
        Dog dog = new Dog();
        Cat cat = new Cat();
        System.out.println(dog.getLengthRun());
        river.overcoming(cat);
        river.overcoming(dog);
        river.overcoming(dog);

        wall.overcoming(cat);

        road.overcoming(dog);
        road.overcoming(dog);
    }
}
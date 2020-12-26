package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(T[] fruits) {
        this.fruits = new ArrayList<T>(Arrays.asList(fruits));
    }

    public void add(T fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare (Box box){
        return (box.getWeight()==this.getWeight());
    }

    public void move(Box <? super T> box){
        box.fruits.addAll(this.fruits);
    }

    public void printInfo(){
        System.out.println( "In this box: " + fruits.toString());
    }
}

package lesson6;

public class Dog extends Animal {

    public Dog(){
        lengthRun = Math.random()> 0.5 ?  500 : 300;
        lengthSwim = 10;
        height = 0.5f;

    }
}

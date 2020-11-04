package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {

        food -= n;
    }
    public void addFood(int food){
        this.food+=food;
    }
    public void info(){
        System.out.println("Plate: " + food);
    }
}
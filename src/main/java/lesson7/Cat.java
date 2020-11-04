package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety=false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate){
        if (plate.getFood()>appetite) {
            plate.decreaseFood(appetite);
            satiety=true;
        }
        else {
            System.out.println("There is too little food for " + this.getName() );
        }
    }
}
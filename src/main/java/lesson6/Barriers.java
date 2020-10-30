package lesson6;

public class Barriers {

    private String name;
    private int meters;
    private char whatAction;


    public char getWhatAction() {
        return whatAction;
    }

    public void setWhatAction(char whatAction) {
        this.whatAction = whatAction;
    }

    public Barriers(String name, int meters, char whatAction) {
        this.name = name;
        this.meters = meters;
        this.whatAction = whatAction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public void overcoming(Animal animal){
        int buf = meters;
        if (meters <= 0) {
            throw new IllegalStateException("This barrier has already been overcome!");
        }
        switch (whatAction){
            case 'r' -> meters-= animal.getLengthRun();
            case 's' -> meters-= animal.getLengthSwim();
            case 'j' -> meters-= animal.getHeight();
        };
        System.out.println(animal.getClass().getSimpleName() + " is trying to overcome the " + name);

        if (meters<=0){
            System.out.println("The barrier was overcome!");
        }

        if (buf==meters){
            System.out.println("The animal can't do this action");
        }
    }
}
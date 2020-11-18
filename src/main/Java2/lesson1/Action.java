package lesson1;

public interface Action {

    void run (Racetrack racetrack);
    void jump (Wall wall);
    boolean isDone ();
    void printInfo();
}

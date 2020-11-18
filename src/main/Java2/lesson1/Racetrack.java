package lesson1;

public class Racetrack extends Barrier{
    private int length;

    public Racetrack( int length) {

        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void act(Action action) {
        action.run(this);
    }
}

package lesson1;

public class Wall extends Barrier{

    private int height;

    public Wall(int height) {

        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void act(Action action) {
        action.jump(this);
    }
}

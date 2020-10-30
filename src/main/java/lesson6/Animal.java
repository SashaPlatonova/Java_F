package lesson6;

public class Animal {
    protected int lengthRun;
    protected int lengthSwim;
    protected float height;

    public int getLengthRun() {
        return lengthRun;
    }

    public int getLengthSwim() {
        return lengthSwim;
    }

    public float getHeight() {
        return height;
    }

    public void run(Barriers barriers, int lengthRun){
        if (this.lengthRun>=lengthRun){
            barriers.overcoming(this);
        }
    }

    public void swim(Barriers barriers, int lengthSwim){
        if (this.lengthSwim>=lengthSwim){
            barriers.overcoming(this);
        }
    }

    public void jump(Barriers barriers, float height){
        if(this.height>=height){
            barriers.overcoming(this);
        }
    }
}

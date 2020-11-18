package lesson1;

public class Robot implements Action{
    private String name;
    private int maxRun;
    private int maxJump;
    private boolean isOnCourse;


    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.isOnCourse = true;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public String getName() {
        return name;
    }

    public boolean isOnCourse() {
        return isOnCourse;
    }

    @Override
    public void run(Racetrack racetrack) {
        if (isOnCourse) {
            if (racetrack.getLength() <= maxRun) {
                System.out.println(name + " пробежал беговую дорожку");
                return;
            }
        }

        System.out.println(name + " не смог преодолеть препятствие");
        isOnCourse = false;

    }

    @Override
    public void jump(Wall wall) {
        if (isOnCourse) {
            if (wall.getHeight() <= maxJump) {
                System.out.println(name + " перепрыгнул стену");
                return;
            }
        }
        System.out.println(name + " не смог преодолеть препятствие");
        isOnCourse = false;

    }

    @Override
    public boolean isDone() {
        return isOnCourse;
    }
    @Override
    public void printInfo() {
        System.out.println(name + ":" + isOnCourse);
    }
}



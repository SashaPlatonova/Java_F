package lesson1;

public class Test {
    public static void main(String[] args) {
        Action[] actions = {new Robot("Nick", 300, 100),
                new Human("John", 1000, 100),
                new Cat("Barsik", 1500, 150)};
        Team team1 = new Team("Winners", actions);
        Course course = new Course(new Barrier[]{new Wall(80), new Racetrack(700),
                new Wall(100), new Racetrack(1000)});
        course.invite(team1);
        course.competition(team1);
        team1.printInfoAll();
        team1.printWhoFinished();

    }
}

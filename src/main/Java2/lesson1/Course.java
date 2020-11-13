package lesson1;

public class Course {
    private Barrier[] barriers;

    public Course(Barrier[] barriers) {
        this.barriers = barriers;
    }

    public Barrier[] getBarriers() {
        return barriers;
    }

    public void invite(Team team){
        System.out.println(team.getName() + " попробуйте преодотель полосу препятствий");
    }
    public void competition(Team team){
        Action[] act = team.getMembers();
        for (Action a: act) {
            for (Barrier bar: barriers) {
                bar.act(a);
                if(!a.isDone()){
                    break;
                }
            }
        }
    }
}

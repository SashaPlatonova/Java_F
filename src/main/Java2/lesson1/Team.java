package lesson1;

public class Team {
    private String name;
    private Action [] members = new Action[4];

    public Team(String name, Action[] members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public Action[] getMembers() {
        return members;
    }

    public void printInfoAll (){
        System.out.println("Members of " + name + ":");
        for (Action a: members) {
            a.printInfo();
        }
    }

    public void printWhoFinished (){
        System.out.println("The distance finished:");
        for (Action a: members) {
            if (a.isDone()){
                a.printInfo();
            }
        }
    }
}

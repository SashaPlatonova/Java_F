package lesson5;



public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int wages;
    private int age;


    public Person(String name, String position, String email, String phone, int wages, int age) {

        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.wages = wages;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void printPerson() {
        System.out.print("Person {" + "\n" +
                "name = " + name + "\n" +
                "position = " + position + "\n" +
                "email = " + email + "\n" +
                "phone = " + phone + "\n" +
                "wages = " + wages + "\n" +
                "age = " + age +
                '}' + "\n\n\n");

    }

}


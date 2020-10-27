package lesson5;

public class TestPerson {
    public static void main(String[] args) {
        int n = 5;
        Person[] personsArr = new Person[n];

        personsArr[0] = new Person("Ivan Ivanov", "engineer", "ivaivanov@box.com",
                "89210009120", 300000, 30);

        personsArr[1] = new Person("Oleg Olegov", "programmer", "olol38@box.com",
                "89997699989", 500000, 24);

        personsArr[2] = new Person("John Black", "manager", "black.jo@box.com",
                "89562566556", 1000000, 41);

        personsArr[3] = new Person("Sarah Teller", "designer", "sarahhhh@box.com",
                "89211001122", 250000, 28);

        personsArr[4] = new Person("Alex Brown", "programmer", "bro.al@box.com",
                "89219696978", 650000, 44);



        for (int i = 0; i<n; i++){
            if (personsArr[i].getAge()>40){
                personsArr[i].printPerson();
            }
        }
    }

}

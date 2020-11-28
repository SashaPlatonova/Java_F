package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumbers {
    private HashMap<String, String> hm = new HashMap<>();


    public void add(String phone, String surname){
        hm.put(phone, surname);
    }

    public void get(String surname){
        ArrayList<String> numbers = new ArrayList<>();
        for (String key: hm.keySet()) {
            if (surname.equals(hm.get(key))){
                numbers.add(key);
                System.out.println(surname + ": " + key);
            }
        }
    }
}

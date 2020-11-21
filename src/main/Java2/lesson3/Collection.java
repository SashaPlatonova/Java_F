package lesson3;

import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;

public class Collection {

    public static Map<String, Integer> getWordsCount(String words[]) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        return map;
    }

    public static void main(String[] args) {
        String wordsArr[] = {"apple", "grape", "lemon", "apple", "lemon", "cherry", "melon", "melon", "cherry",
        "grape", "lemon", "apple", "melon", "melon", "lemon", "cherry", "plump"};

        System.out.println(getWordsCount(wordsArr));

        PhoneNumbers phoneNumbers = new PhoneNumbers();
        phoneNumbers.add("89213454546", "Smith");
        phoneNumbers.add("89609844867", "Brown");
        phoneNumbers.add("89212002112", "Bond");
        phoneNumbers.add("89673007865", "Brown");

        phoneNumbers.get("Brown");
    }
}

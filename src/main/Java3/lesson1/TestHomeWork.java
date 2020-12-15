package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestHomeWork {
    public static void main(String[] args) {
        String[] testArr1 = {"apple", "plump", "pear"};
        Float[] testArr2 = {3.7f, 4.0f, 10.78f};
        swap(testArr1, 0, 2);
        swap(testArr2, 1, 2);
        for (int i = 0; i < testArr1.length; i++) {
            System.out.print(testArr1[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < testArr2.length; i++) {
            System.out.print(testArr2[i] + " ");
        }

        Apple ap1 = new Apple();
        Apple ap2 = new Apple();
        Apple ap3 = new Apple();
        Apple[] appleAr= {ap1, ap2, ap3};

        Orange or1 = new Orange();
        Orange or2 = new Orange();
        Orange or3 = new Orange();
        Orange[] orangeAr = {or1, or2, or3};

        Box<Apple> appleBox = new Box<Apple>(appleAr);
        Box<Orange> orangeBox = new Box<Orange>(orangeAr);

        System.out.println(appleBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        Orange[] oranges = {};
        Box<Orange> orangeBox1 = new Box<>(oranges);
        orangeBox.move(orangeBox1);
        orangeBox1.printInfo();



    }

    public static <T> void swap(T[] arr, int index1, int index2){
        T buf = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = buf;
    }

    public static <T> List<T> ArrToArrayList (T[] arr){
        return Arrays.asList(arr);
    }
}

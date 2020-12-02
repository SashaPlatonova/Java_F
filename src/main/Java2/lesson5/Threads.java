package lesson5;

public class Threads extends Thread{

    static final int size = 10000000;
    static final int h = size / 2;
    
    public static void testThread1(){

        float[] arr = new float[size];

        for (int i = 0; i < size; i++) {
            arr[i]=1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);

    }

    public static void testThread2(){

        float[] arr = new float[size];
        float[] halfArray1 = new float[h];
        float[] halfArray2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, halfArray1, 0, h);
        System.arraycopy(arr, h, halfArray2, 0, h);

        Runnable first = () -> {
            for (int i = 0; i < h; i++) {
                halfArray1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };

        Runnable second = () -> {
            for (int i = 0; i < h; i++) {
                halfArray2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };

        Thread th1 = new Thread(first);
        Thread th2 = new Thread(second);

        th1.start();
        th2.start();

        System.arraycopy(halfArray1, 0, arr, 0, h);
        System.arraycopy(halfArray2, 0, arr, h, h);

        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);

    }

    public static void main(String[] args) {

        testThread1();
        testThread2();

        //results: 12912 - testThread1
        //testThread2 - 219

    }
}

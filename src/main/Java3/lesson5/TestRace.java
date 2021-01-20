package lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TestRace {
    public static final int CARS_COUNT = 4;
    static final CountDownLatch cdStart = new CountDownLatch(CARS_COUNT);
    static final CountDownLatch cdFinish = new CountDownLatch(CARS_COUNT);
    static final CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(), new Tunnel(), new Road());
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        cdStart.await();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        cdFinish.await();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }
}

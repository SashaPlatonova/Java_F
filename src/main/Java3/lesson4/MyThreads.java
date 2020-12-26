package lesson4;

public class MyThreads implements Runnable{
    private static volatile char curLetter = 'A';
    private static Object mon = new Object();
    private char mainLetter;
    private char nextLetter;

        public MyThreads(char mainLetter, char nextLetter) {
            this.mainLetter = mainLetter;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    try {
                        while (curLetter != mainLetter) {
                            mon.wait();
                        }
                        System.out.print(mainLetter);
                        curLetter = nextLetter;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    public static void main(String[] args) {
        new Thread(new MyThreads('A', 'B')).start();
        new Thread(new MyThreads('B', 'C')).start();
        new Thread(new MyThreads('C', 'A')).start();
    }
}

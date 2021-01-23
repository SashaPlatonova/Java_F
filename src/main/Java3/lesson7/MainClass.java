package lesson7;

public class MainClass {
    public static void main(String[] args) {
        TestCore testCore = new TestCore();
        ClassForTest cft = new ClassForTest();
        testCore.start(cft.getClass());

    }
}

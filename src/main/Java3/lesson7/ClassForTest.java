package lesson7;

public class ClassForTest {
//Поле используется для определения успешного прохождения теста
    private boolean isTestSuccess;

    @BeforeSuite
    public void beforeMethod(){
        System.out.println("before method");
    }

//    @BeforeSuite
//    public void beforeMethod2(){
//        System.out.println("before method2");
//    }

    @Test(priority = 2)
    public void method1(){
        System.out.println("test 1");
        isTestSuccess = false;
    }

    @Test(priority = 1)
    public void method2(){
        System.out.println("test 2");
        isTestSuccess = false;
    }

    @Test(priority = 5)
    public void method3(){
        System.out.println("test 3");
        isTestSuccess = true;
    }

    @AfterSuite
    public void afterMethod(){
        System.out.println("after method");
    }

    @Test(priority = 7)
    public void method4(){
        System.out.println("test 4");
        isTestSuccess = true;
    }
}

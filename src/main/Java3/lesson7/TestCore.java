package lesson7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCore {
    private static Object object;
    private int failedTests;
    private boolean isSingleBefore;
    private boolean isSingleAfter;

    public TestCore() {
        isSingleAfter = true;
        isSingleBefore = true;
        failedTests = 0;
    }

    public void start(Class clazz){
        try {
            object = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Method[] methods = clazz.getDeclaredMethods();
        try {
            for (int i = 0; i < 12; i++) {
                for (Method method : methods) {
                    method.setAccessible(true);
                    if(i == 0 &&(method.getAnnotation(BeforeSuite.class) != null)){
                        if(isSingleBefore){
                            method.invoke(object);
                            isSingleBefore = false;
                            continue;
                        }
                        else {
                            throw new RuntimeException("Too many beforeSuite methods");
                        }
                    }
                    if(method.getAnnotation(Test.class) != null) {
                        if (i == method.getAnnotation(Test.class).priority()) {
                            method.invoke(object);
                            Field field = clazz.getDeclaredField("isTestSuccess");
                            field.setAccessible(true);
                            if((boolean)field.get(object)){
                                System.out.println("test was pass successfully");
                            }
                            else {
                                failedTests++;
                            }
                            continue;
                        }
                    }

                    if(i == 11 && (method.getAnnotation(AfterSuite.class) != null)){
                        if (isSingleAfter){
                            method.invoke(object);
                            isSingleAfter = false;
                            continue;
                        }
                        else {
                            throw new RuntimeException("Too many afterSuite methods");
                        }
                    }
            }
        }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        System.out.println("Failed tests: " + failedTests);
    }
}

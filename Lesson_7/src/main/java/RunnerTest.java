import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunnerTest {
    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        List<Method> testM = new ArrayList<>();
        Method[] declareM = testClass.getDeclaredMethods();
        for (Method item : declareM) {
            if (item.isAnnotationPresent(Test.class)) {
                testM.add(item);
            }
        }
        testM.sort(Comparator.comparingInt((Method m)->m.getAnnotation(Test.class).value()).reversed());
        for (Method value : declareM) {
            if (value.isAnnotationPresent(BeforeSuite.class)) {
                if (testM.size() > 0 && testM.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("More then one annotation BeforeSuite.");
                }
                testM.add(0, value);
            }
            if (value.isAnnotationPresent(AfterSuite.class)) {
                if (testM.size() > 0 && testM.get(testM.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("More then one annotation AfterSuite.");
                }
                testM.add(value);
            }
        }
        for (Method method : testM) {
            method.invoke(null);
        }

    }
}

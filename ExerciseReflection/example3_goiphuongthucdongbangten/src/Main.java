import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Calculator
{
    public int add (int a, int b)
    {
        return a + b;
    }
    public int subtract(int a, int b)
    {
        return a - b;
    }
}

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Calculator calculator = new Calculator();
        Class<?> cls = calculator.getClass();

        String methodName = "add";
        Method method = cls.getMethod(methodName, int.class, int.class);

        int a = 1, b = 9;
        Object o = method.invoke(calculator, a, b);
        System.out.println(o);

        System.out.println(calculator.add(1, 9));
    }
}
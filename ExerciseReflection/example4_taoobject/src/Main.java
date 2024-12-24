//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class Example {
    public String field1;
    private String field2;

    public Example(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public Example() {
    }

    @Override
    public String toString() {
        return "Example{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> clazz = Example.class;
        Class<?> cls = Class.forName("Example");

        Object object = cls.getConstructor().newInstance();
        Field f1 = clazz.getField("field1"); // getField(): Lấy các field public
        Field f2 = clazz.getDeclaredField("field2"); // lấý các field được khai báo

        f1.setAccessible(true);
        f2.setAccessible(true);

        f1.set(object, "value1");
        f2.set(object, "value2");

        System.out.println(object);
    }
}
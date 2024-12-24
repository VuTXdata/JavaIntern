import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        // Lấy thông qua tên: Example tải driver của JDBC, Tạo class (của 1 plugin nào đó thông qua tên) -> thao tác bth
        String className = "java.util.ArrayList";
        Class<?> clazz = Class.forName(className);
        System.out.println("Class name: " + clazz.getName());

        // Lấy thông qua đối tượng
        Student student = new Student("Vu", 21);
        Class<?> clazz2 = student.getClass();
        System.out.println("Class name: " + clazz2.getName());

        System.out.println("Constructor: ");
        Constructor<?>[] constructors = clazz2.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(" - " + constructor);
        }

        System.out.println("Method: ");
        Method[] methods = clazz2.getMethods();
        for (Method method : methods) {
            System.out.println(" - " + method);
        }
    }
}
class Student {
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
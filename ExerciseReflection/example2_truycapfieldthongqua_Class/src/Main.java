import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;
    public Person() {}
}

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Person p1 = new Person();
        Person p2 = new Person();

        Class<?> cls = p1.getClass();
        Field nameField = cls.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p2, "Vũ");

        Field ageField = cls.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p2, 21);

        System.out.println("Name: " + nameField.get(p2));
        System.out.println("Age: " + ageField.get(p2));

    // cls đại diện cho class Person mà không phải đối tượng p1, p2

    }
}
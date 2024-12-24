import java.lang.reflect.Field;

public class Main {

    public static String toJson(Object obj) throws IllegalAccessException {
        if(obj == null) return "null";
        StringBuilder json = new StringBuilder("{");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if(value != null)
            {
                json.append("\"").append(field.getName()).append("\": ");
                if(value instanceof String)
                {
                    json.append("\"").append(value).append("\"");
                }
                else
                {
                    json.append(value);
                }
                json.append(", ");
            }
        }
        if(json.length()>1)
        {
            json.setLength(json.length()-2);
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Vũ", 21);
        String r = toJson(person);
        System.out.println(r);
    }
}
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
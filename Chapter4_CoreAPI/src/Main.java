import java.sql.Array;
import java.time.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
/*

        // isEmpty and isBlank
        System.out.println("example isEmpty and isBlank: ");
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(" ".isBlank());
        System.out.println("".isBlank());

        // Formatting Values
        var name  = "Vu";
        var age = 20;

        System.out.println("Case1: Name " + name + " age " + age);
        System.out.println(String.format("Case2: Hello %s!, age %d", name, age));
        System.out.println("Case3: Name %s, age %d".formatted(name, age));

        // Working with arrays
        String [] names = {"a", "z", "b"};
        Arrays.sort(names);
        for(String s : names)
        {
            System.out.println(s);
        }
        System.out.println("character a: " + Arrays.binarySearch(names, "a"));

        // Math
        int x = 3;
        int y = 2;
        int z = (int) Math.pow(x, y);
        System.out.println(z);

        // random
        System.out.println((int)(Math.random()*9) + 1);
*/

        // Working with dates and times
/*
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now());
        System.out.println(ZonedDateTime.now());

        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Time of Tokyo: " + tokyoTime);
*/
        var date = LocalDate.of(2024, Month.DECEMBER, 30);
        System.out.println(date);
        date = date.plusDays(1);
        System.out.println(date);
        date = date.plusWeeks(1);
        System.out.println(date);
        date = date.plusMonths(1);
        System.out.println(date);
        date = date.plusYears(1);
        System.out.println(date);

        Period period = Period.ofDays(2);
        System.out.println(period);
        System.out.println(LocalDate.now().plus(period));
        ;
    }
}
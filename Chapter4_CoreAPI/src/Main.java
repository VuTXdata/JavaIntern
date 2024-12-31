import java.sql.Array;
import java.time.*;
import java.time.temporal.ChronoUnit;
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

        // Working with period
/*        var date = LocalDate.of(2024, Month.DECEMBER, 30);
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
        */

        // Working with durations
        /*
        var daily = Duration.ofDays(3);
        System.out.println(daily);
        var hourly = Duration.ofHours(1);
        System.out.println(hourly);
        var everyMinute = Duration.ofMinutes(1);
        System.out.println(everyMinute);
        var everySecond = Duration.ofSeconds(1);
        System.out.println(everySecond);
        var everyMillis = Duration.ofMillis(1);
        System.out.println(everyMillis);
        var everyNano = Duration.ofNanos(1);
        System.out.println(everyNano);

        var daily2 = Duration.of(1, ChronoUnit.HOURS);
        System.out.println(daily2);
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        System.out.println(ChronoUnit.MINUTES.between(one, two));
        System.out.println(ChronoUnit.HOURS.between(one, two));
        */

/*
        LocalTime truncate = LocalTime.of(23, 59, 59);
        System.out.println("LocalTime truncated: " + truncate.truncatedTo(ChronoUnit.MINUTES));

        var timeNow = LocalDateTime.now();
        var nextTime = timeNow.plus(1, ChronoUnit.HOURS);
        var nextTime2 = timeNow.plus(Duration.ofHours(1)).truncatedTo(ChronoUnit.MINUTES);
        System.out.println(nextTime);
        System.out.println(nextTime2);
        */

/*        var date = LocalDate.of(2024, 5, 25);
        var date1 = LocalDate.of(2024, 5, 25);
        var period = Period.ofDays(1);
        var days = Duration.ofDays(1);
        System.out.println(date.plus(period));
        // System.out.println(date1.plus(days));
 */
/*
       var now = Instant.now();
       var later = Instant.now();
       var duration = Duration.between(now, later);
       System.out.println("Time: " + duration.toNanos());
       */

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toInstant(ZonedDateTime.of(now, ZoneId.systemDefault()).getOffset()));

    }
}
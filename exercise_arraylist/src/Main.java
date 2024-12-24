import java.sql.SQLOutput;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        MyList ml1 = new MyList();
        ml1.add(1);
        ml1.add(2);
        ml1.add(3);
        ml1.add(4);
        ml1.add(5);

        MyList ml2 = new MyList();
        ml2.add(1);
        ml2.add(2);
        ml2.add(6);
        //
        System.out.println("ml1: " + ml1);
        System.out.println("ml2: " + ml2);
        ml1.addAll(ml2);
        System.out.println("1: " + ml1);
        ml1.addAll(1, ml2);
        System.out.println("2: " + ml1);
        System.out.println("3: "  + ml1.subList(0, 1));

    }
}

package exceptions.ex5;

public class Test2 {

    public static void main(String[] args) {

        // try without catch or finally
        try (R1 r1 = new R1("r1")) {
            //r1 = new R1();  // implicit final, nu se poate reasigna !!!
            //some logic here
        }
    }
}

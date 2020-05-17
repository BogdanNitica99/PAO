package lambda.ex2;

public class Main {

    public static void main(String[] args) {

        I1 i11 = (x1, x2) -> x1 + x2;
        I1 i12 = (int x1, int x2) -> x1 + x2;
        I1 i13 = (x1, x2) -> {
            return x1 + x2;
        };

        I2 i21 = x -> 10 * x;
        I2 i22 = (x) -> 10 * x;
        I2 i23 = (int x) -> 10 * x;

    }

}

package primitive_types;

public class Byte {

    static byte defaultValue;

    public static void main(String[] args) {

        // byte --> 8-bit integer values
        byte b1 = -128;  // local variables must be initialized before use
        System.out.println(b1);

        byte b2 = 127;
        System.out.println(b2);
        b2++;

        System.out.println(b2++);
        System.out.println(++b2);

        //byte b3 = 12345;  // doesn't compile, assigned value is an int, by default

        System.out.println(defaultValue);
    }

}

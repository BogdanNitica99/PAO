package exceptions.ex3;

import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;

public class Ex3 {

    public static void main(String[] args) {

        try (R2 r1 = new R2("r1"); R2 r2 = new R2("r2"))
        {
            System.out.println("In try block");
            throw new Exception("exception in try block");
        }
        catch( Exception e){
            System.out.println(e);
            // suppressed exceotions
            Throwable[] suppressedExceptions = e.getSuppressed();
            System.out.println(Arrays.toString(suppressedExceptions));
        }
        finally {
            System.out.println("finally");
        }
    }
}

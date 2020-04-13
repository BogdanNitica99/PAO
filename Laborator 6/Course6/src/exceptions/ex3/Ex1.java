package exceptions.ex3;

public class Ex1 {

    public static void main(String[] args) throws Exception {

        R1 r1 = null;
        try {
            r1 = new R1();
            //some logic
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {

            if(r1 != null) {
                r1.close();
            }
        }
    }
}

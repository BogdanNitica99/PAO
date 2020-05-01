package exceptions.ex5;

public class Test1 {

    public static void main(String[] args) {

        R1 r1 = null;
        try {
            r1 = new R1("r1");
            // some logic
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (r1 != null) {
                try {
                    // close() can throw an exception
                    r1.close();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }
}

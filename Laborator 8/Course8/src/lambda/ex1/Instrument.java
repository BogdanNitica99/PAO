package lambda.ex1;

@FunctionalInterface // this annotation guaranties no other abstract method can be added to this interface
public interface Instrument {

    // exactly one abstract method
    void play();

    default void clean(){
        System.out.println("in default method");
    }

    static void inStatic(){
        System.out.println("in static method");
    }

}

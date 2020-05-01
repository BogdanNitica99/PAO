package exceptions.ex5;

public class R1 implements AutoCloseable{

    private String name;

    public R1(String name) {
        this.name = name;
    }

    @Override
    public void close() {
        System.out.println("closing " + name);
    }
}

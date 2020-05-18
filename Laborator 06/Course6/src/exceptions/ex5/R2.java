package exceptions.ex5;

public class R2 implements AutoCloseable {

    String name;

    public R2(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        System.out.println("closing resource " + name);
        throw new Exception("exception while trying to close resource " + name);
    }
}

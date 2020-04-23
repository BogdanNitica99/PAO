package lambda.ex1;

public class Ex1 {

    public static void main(String[] args) {

        Instrument guitar = new Guitar();
        guitar.play();

        Instrument piano = new Instrument() {
            @Override
            public void play() {
                System.out.println("playing piano");
            }
        };
        piano.play();

        Instrument i1 = () -> System.out.println("new instrument playing");
        i1.play();
    }
}

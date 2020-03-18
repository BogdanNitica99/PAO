package polymorphims.zoo.ierbivor;

public class Elefant extends Ierbivor {

    public Elefant(String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "trambiteaza";
    }

    @Override
    public void scoateSunet() {
        System.out.println("elefantul " + this.sunetSpecific);
    }
}

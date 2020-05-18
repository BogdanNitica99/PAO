package polymorphims.zoo.omnivor;

public class Urs extends Omnivor {

    public Urs(String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "mormaie";
    }

    @Override
    public void scoateSunet() {
        System.out.println("Ursul " + this.sunetSpecific);
    }
}

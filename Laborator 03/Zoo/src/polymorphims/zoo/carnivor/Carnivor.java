package polymorphims.zoo.carnivor;

import polymorphims.zoo.Animal;

public abstract class Carnivor extends Animal {

    public Carnivor(String nume, int varsta) {
        super(nume, varsta);
        this.tipHrana = "carne";
    }

    @Override
    public void seHraneste() {
        System.out.println(this + " se hraneste cu " + this.tipHrana);
    }
}

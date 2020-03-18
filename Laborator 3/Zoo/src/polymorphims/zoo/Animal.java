package polymorphims.zoo;

public abstract class Animal {

    private int nrIdentificare;
    private String nume;
    private int varsta;
    protected String tipHrana;
    protected String sunetSpecific;

    public Animal(String nume, int varsta){
        nrIdentificare = hashCode();
        this.nume = nume;
        this.varsta = varsta;
    }

    public abstract void seHraneste();

    public abstract void scoateSunet();

    public void afiseazaDetalii(){
        System.out.println("Acesta este " + this.toString());
    }

    @Override
    public String toString() {
        return "Animal din categoria " + this.getClass().getSuperclass().getSimpleName() +
                ", din specia " + this.getClass().getSimpleName() + "{" +
                "nrIdentificare " + nrIdentificare +
                ", nume " + nume + '\'' +
                " varsta " + varsta +
                "}";
    }
}

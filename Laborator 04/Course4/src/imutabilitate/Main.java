package Imutabilitate;

public class Main {

    public static void main(String[] args){
        Adresa domiciliu = new Adresa("Timisoara", "4A");
        Persoana persoana = new Persoana(1, "Teo", domiciliu);

        /*incercare alterare camp nume, care este de tip String, imutabil */
        System.out.println(persoana.getNume().toUpperCase());
        System.out.println(persoana);

        /*incercare alterare valoare membru prin modificarea valorilor instantei date ca parametru
        la instantierea clasei imutabile*/
        String stradaUppercase = domiciliu.getStrada().toUpperCase();
        domiciliu.setStrada(stradaUppercase);
        System.out.println(persoana);

        /*inceracare alterare continu prin intermediul seterului */
        Adresa adresaDomiciliu = persoana.getAdresa();
        String strada = adresaDomiciliu.getStrada();
        adresaDomiciliu.setStrada(strada.toUpperCase());
        System.out.println(persoana);

    }

}

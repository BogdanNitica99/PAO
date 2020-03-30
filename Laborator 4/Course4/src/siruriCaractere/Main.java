package siruriCaractere;

public class Main {

    static String membruClasa;

    public static void main(String[] args) {

        System.out.println(membruClasa);

        String s1 = "";
        String s2 = "abc";

        System.out.println(s2);
        s2.toUpperCase();
        System.out.println(s2);

        s2 = s2.toUpperCase();
        System.out.println(s2);

        String s3 = "cde";
        String s4 = new String("cde"); /* alocare de memorie explicita pe heap */
        String s5 = "cde"; /* referinta catre acelasi obiect cde din String pool */

        System.out.println(s3 == s4); // false, referinte diferite catre obiecte diferite
        System.out.println(s4 == s5); // false
        System.out.println(s3 == s5); // true
        System.out.println(s3.equals(s4));

        s4 = s4.intern(); /* trecere explicita in String pool */
        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // true

        String adresa = s1 + s2 + s3 + s4.toUpperCase() + s5.length();

        StringBuilder sb = new StringBuilder(adresa);
        sb.append(1234); // se returneaza aceiasi instanta de StringBuilder
        System.out.println("string builder: " + sb);

        String s6 = adresa + sb; //concatenare string si StringBuilder
        System.out.println("s6 = " + s6);

        StringBuffer sbf = new StringBuffer(adresa); //conversie de la String la StringBuffer
        StringBuffer sbf1 = new StringBuffer(sb); // conversie de la StringBuilder la StringBuffer
        StringBuilder sb1 = new StringBuilder(sbf); // conversie de la StringBuffer la StringBuilder

    }

}

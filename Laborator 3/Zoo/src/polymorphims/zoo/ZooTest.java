package polymorphims.zoo;

import polymorphims.zoo.carnivor.Leu;
import polymorphims.zoo.carnivor.Pisica;
import polymorphims.zoo.ierbivor.Cal;
import polymorphims.zoo.ierbivor.Elefant;
import polymorphims.zoo.omnivor.Caine;
import polymorphims.zoo.omnivor.Urs;

import java.util.Scanner;

public class ZooTest {

    public static void main(String[] args) {

         Integer nrAnimaleZoo = Integer.valueOf(args[0]);

        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Precizati nr max de aniamle ce pot fi gazduite la zoo: ");
        //int nrAnimaleZoo = scanner.nextInt();
        //scanner.close();

        Zoo zooBucuresti = new Zoo(nrAnimaleZoo);

        adaugaAnimalZoo(zooBucuresti);

        for(int i=0;(i < zooBucuresti.animaleZoo.length) && (zooBucuresti.animaleZoo[i] != null); i++) {
            Animal animal = zooBucuresti.animaleZoo[i];
            animal.afiseazaDetalii();
            animal.seHraneste();
            animal.scoateSunet();
        }
    }

    public static void adaugaAnimalZoo(Zoo zoo) {

        Leu leu = new Leu("Simba", 7);
        zoo.adaugaAnimal(leu);

        Elefant elefant = new Elefant("Eli", 10);
        zoo.adaugaAnimal(elefant);

        Urs urs = new Urs( "Fram", 4);
        zoo.adaugaAnimal(urs);

        Pisica pisica = new Pisica("Tom", 2);
        zoo.adaugaAnimal(pisica);

        Caine caine = new Caine("Toto", 3);
        zoo.adaugaAnimal(caine);

        Cal cal = new Cal("Thunder", 3);
        zoo.adaugaAnimal(cal);
    }
}

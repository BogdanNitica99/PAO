import Products.*;

import java.lang.reflect.TypeVariable;

public class Test {

    public static void main(String[] args) {

        Electronic[] electronics = new Electronic[4];
        Software[] softwares = new Software[3];
        int el_index = 0;
        int so_index = 0;

        Laptop laptop1 = new Laptop("Lenovo", "23 Mar", 200, "Ubuntu", 16);
        Laptop laptop2 = new Laptop("Dell", "20 Apr", 250, "Fedora", 32);
        Phone phone1 = new Phone("Samsung", "Mar 2018", 90, 5,"24h", true);
        Tv tv1 = new Tv("Samsung", "Ian 2015", 210, 15, 20,false);

        electronics[el_index] = laptop1;
        el_index += 1;
        electronics[el_index] = laptop2;
        el_index += 1;
        electronics[el_index] = phone1;
        el_index += 1;
        electronics[el_index] = tv1;
        el_index += 1;

        Antivirus antivirus1 = new Antivirus("Bit", 2, 20, 3,true);
        OperatingSystem operatingSystem1 = new OperatingSystem("Linux", 20,0,true);
        Game game1 = new Game("Mario", 1,11,2,3,"Steam");

        softwares[so_index] = antivirus1;
        so_index += 1;
        softwares[so_index] = operatingSystem1;
        so_index += 1;
        softwares[so_index] = game1;
        so_index += 1;

    }

}

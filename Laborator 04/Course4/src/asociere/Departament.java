package asociere;

import java.util.Arrays;

public class Departament {

    private String name;
    private Profesor[] profesori;

    public Departament(String name, Profesor[] profesori) {
        this.name = name;
        this.profesori = profesori;
    }

    public String getName() {
        return name;
    }

    public Profesor[] getProfesori() {
        return profesori;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfesori(Profesor[] profesori) {
        this.profesori = profesori;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "name='" + name + '\'' +
                ", profesori=" + Arrays.toString(profesori) +
                '}';
    }
}

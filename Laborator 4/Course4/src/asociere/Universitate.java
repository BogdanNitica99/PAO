package asociere;

import java.util.Arrays;

public class Universitate {

    private String name;
    private Departament[] departments;

    public Universitate(String name, Departament[] departments) {
        this.name = name;
        this.departments = Arrays.copyOf(departments, departments.length);
    }

    @Override
    public String toString() {
        return "Universitate{nume: " + name + ", departamente: " + Arrays.toString(departments) + "}";
    }
}

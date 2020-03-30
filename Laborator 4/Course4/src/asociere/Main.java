package asociere;

public class Main {

    public static void main(String[] args) {

        Profesor profesorPrincipalMate = new Profesor(1, "Popescu");
        Profesor profesorSecundarMate = new Profesor(2, "Ionescu");
        Profesor profesorInfo = new Profesor(3, "Anghel");
        Profesor profesorMateSiInfo = new Profesor(4, "Petrescu");
        Profesor profesorInfoSiMate = new Profesor(5, "Andrei");

        Profesor[] profesoriDepartamentMate = new Profesor[]{profesorPrincipalMate, profesorSecundarMate, profesorInfoSiMate, profesorMateSiInfo};
        Profesor[] profesoriDepartamentInfo = new Profesor[]{profesorInfo, profesorInfoSiMate, profesorMateSiInfo};

        Departament departamentInfo = new Departament("informatica", profesoriDepartamentInfo);
        Departament departamentMate = new Departament("matematica", profesoriDepartamentMate);
        departamentMate.setProfesori(new Profesor[]{profesorPrincipalMate, profesorSecundarMate, profesorInfoSiMate, profesorMateSiInfo});


        Departament[] departamente = new Departament[]{departamentInfo, departamentMate};
        Universitate unibuc = new Universitate("UNIBUC", departamente);

        System.out.println(unibuc);

        departamentInfo = null;
        System.out.println(unibuc);

        System.out.println(departamentMate);
        profesorSecundarMate = null;
        System.out.println(departamentMate);
        System.out.println(profesorSecundarMate);
    }

}

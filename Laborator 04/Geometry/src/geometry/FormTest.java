package geometry;

public class FormTest {

    private int maxForms;
    private Form[] forms;
    private int index;

    public FormTest(int maxForms) {
        if(maxForms > 0){
            this.maxForms = maxForms;
            this.index = 0;
            this.forms = new Form[maxForms];
        }
        else {
            throw new RuntimeException("The number must be a positive integer!");
        }
    }

    public void addForm(Form form) {
        if(index < maxForms) {
            this.forms[this.index] = form;
            this.index ++;
        }
        else {
            throw new RuntimeException("There is not enough space!");
        }
    }

    public static void main(String args[]) {
        FormTest form = new FormTest(3);

        Triangle tr1 = new Triangle("red", 5, 10);
        Circle cr1 = new Circle("yellow", 3);
        Triangle tr2 = new Triangle("blue", 2, 4);

        form.addForm(tr1);
        form.addForm(tr2);
        form.addForm(cr1);

        /*
        for (int i = 0; i < form.index; i++) {
            System.out.print(form.forms[i] + "\n");
        }
        */

        for (int i=0; i < form.index; i++) {
            Form formDownCast = form.forms[i];

            System.out.println(formDownCast + " ");

            if (formDownCast instanceof Triangle) {
                Triangle triangle = (Triangle) formDownCast;
                triangle.printTriangleDimensions();
            }
            else if (formDownCast instanceof Circle) {
                Circle circle = (Circle) formDownCast;
                circle.printCircleDimensions();
            }
        }
        System.out.println("Without instanceof\n");
        /* Implementation using polymorphism without the use of instanceof */
        for(int i=0;i < form.index;i ++) {
            form.forms[i].printDimension();
        }
    }

}

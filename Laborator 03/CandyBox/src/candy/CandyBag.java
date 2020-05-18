package candy;

public class CandyBag {
    private int maxBoxes;
    private CandyBox[] boxes;
    private int currentBox;

    public CandyBag(int maxBoxes) {
        if(maxBoxes > 0) {
            this.maxBoxes = maxBoxes;
            this.currentBox = 0;
            this.boxes = new CandyBox[maxBoxes];
        }
        else {
            throw new RuntimeException("The number must be a positive integer!");
        }
    }

    public void addBox(CandyBox box) {
        if(currentBox < maxBoxes) {
            this.boxes[this.currentBox] = box;
            System.out.println("Added box " + box.getClass().getSimpleName() + " at position " + this.currentBox);
            this.currentBox ++;
        }
        else {
            throw new RuntimeException("There is not enough space!");
        }
    }

    public static void main(String[] args) {
        CandyBag bag = new CandyBag(5);

        bag.addBox(new Heidi(4));
        bag.addBox(new Milka(3,2));
        bag.addBox(new Milka(2,5));
        bag.addBox(new Lindt(1,3,2));
        bag.addBox(new Lindt(4,1,2));

        System.out.println(bag.boxes[1].equals(bag.boxes[3])); //returns False Milka != Lindt
        System.out.println(bag.boxes[1].equals(bag.boxes[2])); //returns True Milka == Milka
        System.out.println(bag.boxes[3].equals(bag.boxes[4])); //return True Lindt == Lindt
    }
}

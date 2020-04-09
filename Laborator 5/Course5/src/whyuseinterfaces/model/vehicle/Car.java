package whyuseinterfaces.model.vehicle;

import whyuseinterfaces.Washable;

public class Car implements Washable {

    @Override
    public void wash() {
        System.out.println("washing a car");
    }
}

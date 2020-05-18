package whyuseinterfaces.model.constructionitems;

import whyuseinterfaces.Washable;

public class Window implements Washable {

    @Override
    public void wash() {
        System.out.println("washing a window");
    }
}

package whyuseinterfaces.example5;

public class C1 implements Interface1, Interface2{

    // both inherited methods have the same signature
    // this concrete class must provide own implementation of method m1(), otherwise -> compilation error
    @Override
    public void m1(){
        // we can call methods from interfaces using: [InterfaceName].super.[methodName]
        Interface1.super.m1();
        Interface2.super.m1();
        System.out.println("m1 in class C1");
    }
}

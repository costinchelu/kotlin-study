package ro.ccar.java;

class FooJ {

    private final int x = 0;

    public int getX() {
        return this.x;
    }

    public void f() {}
}


final class BarJ extends FooJ {

    @Override
    public void f() {}

    @Override
    public int getX() {
        return 0;
    }

    public final class BazJ {

        public final void g() {
            BarJ.super.f();
            int n = BarJ.super.getX();
            System.out.println(n);
        }
    }
}


public class InnerClassesJ {
}

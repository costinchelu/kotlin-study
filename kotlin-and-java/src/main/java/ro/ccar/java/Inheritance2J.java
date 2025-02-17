package ro.ccar.java;


class Base2J {

    private final String attr1;
    private final int attr2;
    private final String attr3;

    public Base2J(String attr1, int attr2, String attr3) {
        this.attr1 = attr1;
        this.attr2 = attr2;
        this.attr3 = attr3;
    }

    public Base2J(String attr1) {
        this(attr1, 1, "First Constructor");
    }

    public Base2J(String attr1, int attr2) {
        this(attr1, attr2, "Second Constructor");
    }
}


class Derived2J1 extends Base2J {

    public Derived2J1(String attr1) {
        super(attr1);
    }
}

class Derived2J2 extends Base2J {

    public Derived2J2(String attr1, int attr2) {
        super(attr1, attr2);
    }
}


public class Inheritance2J {
}

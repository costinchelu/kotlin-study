package ro.ccar.java;

interface Interface1J {

    public String openMethod1();

    public String openMethod3();

    public default String openMethod4() {
        return "This method is default and we don't need to override as it is not abstract";
    }
}

abstract class Abstract1J {

    public abstract String openMethod4();

    public String openMethod5() {
        return "This method is not abstract, so, there is no need to override it";
    }
}

class Base3J {

    public String openMethod1() {
        return "1";
    }

    public String openMethod2() {
        return "2";
    }
}

// classes can only extend one class but implements one or more interfaces
final class NotExtendableClassJ extends Base3J implements Interface1J {

    @Override
    public String openMethod1() {
        return "Can still override this method further";
    }

    @Override
    public final String openMethod2() {
        return "Cannot be further overridden (final)";
    }

    @Override
    public String openMethod3() {
        return "Must be implemented - interface (also abstract)";
    }
}


class Base5J extends Abstract1J {

    @Override
    public String openMethod4() {
        return "Must be implemented - abstract";
    }
}



public class BasicClassOverrides {

    public static void main(String[] args) {
        NotExtendableClassJ notExtendableClassJ = new NotExtendableClassJ();
        System.out.println(notExtendableClassJ.openMethod1());
        System.out.println(notExtendableClassJ.openMethod2());
        System.out.println(notExtendableClassJ.openMethod3());
        System.out.println(notExtendableClassJ.openMethod4());

        Base5J base5J = new Base5J();
        System.out.println(base5J.openMethod4());
        System.out.println(base5J.openMethod5());
    }
}

package ro.ccar.java;

class Base3J {

    public String openMethod1() {
        return "1";
    }

    public String openMethod2() {
        return "2";
    }
}

final class NotExtendableClassJ extends Base3J {

    @Override
    public String openMethod1() {
        return "Can still override this method further";
    }

    @Override
    public final String openMethod2() {
        return "Cannot further overridden";
    }
}



public class BasicClassOverrides {
}

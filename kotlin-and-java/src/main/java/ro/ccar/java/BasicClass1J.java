package ro.ccar.java;

public class BasicClass1J {

    private String name;

    public BasicClass1J(String name) {
        this.name = name;
    }
}
// by default, name is nullable but we can do: public BasicClassJ(@NotNull String name)
// if we need otherwise

//class Exec {
//    public static void main(String[] args) {
//        BasicClassJ basicClassJ = new BasicClassJ(null);
//    }
//}
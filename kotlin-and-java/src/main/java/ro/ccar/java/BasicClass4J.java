package ro.ccar.java;

import java.util.Objects;

final class AClosedClassJ {

    private final String str;

    public AClosedClassJ(String str) {
        this.str = str;
    }

    public final String getStr() {
        return this.str;
    }
}


final class AnObjectJ {

    private static String str;

    public static final AnObjectJ INSTANCE;

    static {
        AnObjectJ anObjectJ;
        INSTANCE = anObjectJ = new AnObjectJ();
    }

    private AnObjectJ() { }

    public final String getStr() {
        return str;
    }

    public final void setStr(String string) {
        str = string;
    }
}


class AnOpenClassJ {

    private final String str;

    public AnOpenClassJ(String str) {
        this.str = str;
    }

    public final String getStr() {
        return this.str;
    }
}


final class ADataClassJ {

    private final String str;

    public ADataClassJ(String str) {
        this.str = str;
    }

    public final String getStr() {
        return this.str;
    }

    public final String component1() {
        return this.str;
    }

    // copy constructor
    public ADataClassJ(ADataClassJ other) {
        this.str = other.str;
    }

    @Override
    public String toString() {
        return "ADataClass(str=" + this.str + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ADataClassJ that = (ADataClassJ) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}

// a kind of data class
record ARecordJ(String str) {

    public ARecordJ(ARecordJ other) {
        this(other.str());
    }
    // records automatically provides:
    //          canonical constructor,
    //          toString(),
    //          equals(),
    //          hashCode()
    //          getter methods.
    // However, they do not automatically provide a copy constructor
}


public class BasicClass4J {
}
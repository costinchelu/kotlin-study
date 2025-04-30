package ro.ccar.java;


import org.jetbrains.annotations.NotNull;
import static ro.ccar.kt.ExtendStandardLibraryKKt.concatenatedLengthK;


public class ExtendStandardLibraryJ {

    public static int concatenatedLength(@NotNull String $receiver, @NotNull String str) {
        return $receiver.length() + str.length();
    }

    public static void main(String[] args) {
        int len = ExtendStandardLibraryJ.concatenatedLength("one string", "another string");
        System.out.println(len);

        int lenK = concatenatedLengthK("one string", "another string");
        System.out.println(lenK);

    }
}



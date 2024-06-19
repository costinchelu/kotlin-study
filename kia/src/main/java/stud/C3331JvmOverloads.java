package stud;


import java.util.List;

import static ch03.JoinToStringUtilityFunction._3_2_3_JoinToStringFinalKt.SOME_CONSTANT;
import static ch03.JoinToStringUtilityFunction._3_2_3_JoinToStringFinalKt.join;
//import ch03.JoinToStringUtilityFunction._3_3_3_1_JoinToStringFinalKt.*;
import ch03.JoinToString.UsingJoinToString;


public class C3331JvmOverloads {

    public static void main(String[] args) {

        // kotlin file: 3_3_3_1_JoinToStringFinal.kt
        // java will create a class called _3_3_3_1_JoinToStringFinalKt [kt extension will be Kt and because the file starts with a number, a _ is added]

        // this kotlin file has a package of ch03.JoinToStringUtilityFunction
        // this will be kept as Java package name

        // ALL top-level functions in a kotlin file are compiled to static methods of that class, hence join function will be static in Java

        // we can change the name of that file in Java by adding a notation in the Kotlin file:
        // @file:JvmName("StringFunctions")
        // package strings
        // in this case in Java we will import: strings.StringFunctions;

        // Kotlin's @JvmOverloads:

        String join1 = join(List.of("str1", "str2", "str3"));
        String join2 = join(List.of("str1", "str2", "str3"), " # ");
        String join3 = join(List.of("str1", "str2", "str3"), " # ", "> ");
        String join4 = join(List.of("str1", "str2", "str3"), " # ", "> ", " <");

        System.out.println(join1);
        System.out.println(join2);
        System.out.println(join3);
        System.out.println(join4);

        String join5 = UsingJoinToString.joinToString(List.of("str1", "str2", "str3"), " | ", ">>> ", " <<<");
        System.out.println(join5);

        System.out.println(SOME_CONSTANT);


        ViewJ viewJ = new ButtonJ();
        viewJ.click();
        ViewJ.showOff();

        // package.package.fileKt for accessing (top-level) static methods and attributes
        // package.package.class for accessing classes
        ch03.ex3_4_2_NoOverridingForExtensionFunctions1.View view = new ch03.ex3_4_2_NoOverridingForExtensionFunctions1.Button();
        view.click();
        ch03.ex3_4_2_NoOverridingForExtensionFunctions1._3_3_4_2_NoOverridingForExtensionFunctions1Kt.showOff(view);

        ch03.ex3_4_2_NoOverridingForExtensionFunctions1.Button button = new ch03.ex3_4_2_NoOverridingForExtensionFunctions1.Button();
        button.click();
        ch03.ex3_4_2_NoOverridingForExtensionFunctions1._3_3_4_2_NoOverridingForExtensionFunctions1Kt.showOff(button);

    }
}


class ViewJ {

    public void click() {
        System.out.println("ViewJ clicked");
    }

    public static void showOff() {
        System.out.println("I'm a viewJ");
    }
}

class ButtonJ extends ViewJ {

    @Override
    public void click() {
        System.out.println("ButtonJ clicked");
    }

    public static void showOff() {
        System.out.println("I'm a buttonJ");
    }
}

package ro.ccar.java;

import can.be.named.as_needed.BasicsK;

import java.util.Arrays;
import java.util.List;

public class BasicsJ {

    private final int instanceConstant = 3;

    private void methodReturningVoid(String param1, int param2) {

        // variable
        int x = 1;
        var x1 = 1;

        // constant
        final int y = 2;
    }

    void instantiationExample() {
        // instantiating an object from Kotlin code
        BasicsK basicsK = new BasicsK();
    }

    char switchExample(int value) {
        return switch (value) {
            case 0, 1, 2, 3, 4 -> 'a';
            case 5 -> 'b';
            case 6, 7, 8 -> 'c';
            case 9 -> 'd';
            default -> {
                if (value >= 10 && value <= 20) {
                    yield 'e';
                } else {
                    throw new IllegalArgumentException();
                }
            }
        };
    }

    void oldCaseExample(int value) {
        String s;
        switch (value) {
            case 0, 1, 2, 3, 4:
            {
                s = "a";
                break;
            }
            case 5:
            {
                s = "b";
                break;
            }
            case 6, 7, 8:
            {
                s = "c";
                break;
            }
            case 9:
            {
                s = "d";
                break;
            }
            default:
            {
                s = "e";
                break;
            }
        }
        System.out.println(s);
    }


    void forLoopExample() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for (int number: intList) {
            System.out.println(number);
        }
    }

    private void castingExample() {
        Object obj = "Hello";

        if (obj instanceof String) {
            String message = (String) obj; // Explicit type casting
        }
    }

    private void functionalExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    void assignFromIf(int a, int b) {
        int max;
        if (a > b) {
            System.out.println("choose a(" + a + ")");
            max = a;
        } else {
            System.out.println("choose b(" + b + ")");
            max = b;
        }
        System.out.println("Max: " + max);
    }

    void assignIfNotNull(String value) {
        if (value != null) {
            int length = value.length();
            System.out.println(length);
        }
        Integer length2 = (value != null) ? value.length() : null;
        System.out.println(length2);
    }

    static void staticMethod1() {
        System.out.println("I am calling the user...");
    }

    static int staticMethod2() {
        return 12;
    }
}

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

    private void instantiationExample() {
        // instantiating an object from Kotlin code
        BasicsK basicsK = new BasicsK();
    }

    private char switchExample(int value) {
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

    private char ifExample(int value) {
        char result;
        if (value >= 0 && value < 5) {
            result = 'a';
        } else if (value == 5) {
            result = 'b';
        } else if (value == 6 || value == 7 || value == 8) {
            result = 'c';
        } else if (value == 9) {
            result = 'd';
        } else if (value >= 10 && value <= 20) {
            result = 'e';
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private void forLoopExample() {
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
}

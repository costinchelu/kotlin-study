package stud;

import java.util.function.BinaryOperator;

public class C212DeclaringFunctions {

    public static void main(String[] args) {
        System.out.println(max(1, 2));

        BinaryOperator<Integer> max = (a, b) -> a;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}


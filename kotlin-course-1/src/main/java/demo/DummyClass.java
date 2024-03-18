package demo;

import java.util.Arrays;

public class DummyClass {

    public String isVacationTime(boolean onVacation) {
        return onVacation ? "I'm on vacation" : "I'm working";
    }

    public void printNumbers(int[] numbers) {
//        Arrays.stream(numbers).forEach(System.out::println);
        System.out.println(Arrays.toString(numbers));
    }

    public static void main(String[] args) {

    }
}

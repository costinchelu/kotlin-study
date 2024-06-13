package stud;

import java.util.Comparator;
import java.util.List;


record Person(
        String name,
        int age
){}


public class C11ATasteOfKotlin {

    public static void main(String[] args) {

        List<Person> persons = List.of(
                new Person("Alice", 27),
                new Person("Bob", 0)
        );

        Person oldest = persons.stream()
                .max(Comparator.comparingInt(Person::age))
                .orElse(new Person("none", 0));

        System.out.println(oldest);
    }
}
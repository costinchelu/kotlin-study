package stud;

import ch02.Person.Person;

public class AccessKotlinClass {

    public static void main(String[] args) {

        Person person = new Person("Bob", true);
        String name = person.getName();
        boolean student = person.isStudent();
        person.setStudent(false);
    }
}

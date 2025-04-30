package ro.ccar.java;

import ro.ccar.kt.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectionsJ {

    public long count(List<Long> clientIds) {
        return clientIds.stream()
                .filter(id -> id > 10)
                .count();
    }

    public List<String> map(List<Long> clientIds) {
        return clientIds.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public List<String> mapNotNull(List<Long> clientIds) {
        return clientIds.stream()
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public void joinToString(List<Long> clientIds) {
        System.out.println(clientIds.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public void joinToStringWithOptions(List<Long> clientIds) {
        System.out.println(clientIds.stream()
                .map(id -> "ID: " + id)
                .collect(Collectors.joining("; ", "clientIds: ", ".")));
    }

    public List<Long> instanceOf(List<Number> clientIds) {
        return clientIds.stream()
                .filter(id -> id instanceof Long)
                .map(id -> (Long) id)
                .collect(Collectors.toList());
    }

    public Map<LocalDate, List<Person>> groupBy(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getDayOfBirth));
    }

    public Map<String, Person> toMap(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.toMap(Person::getName, person -> person));
    }

    public Map<String, LocalDate> toMapMapped(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.toMap(Person::getName, Person::getDayOfBirth));
    }
}

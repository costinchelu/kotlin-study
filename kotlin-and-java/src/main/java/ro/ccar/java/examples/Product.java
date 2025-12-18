package ro.ccar.java.examples;

public record Product(
        String name,
        String category,
        double price,
        int sold
) {}

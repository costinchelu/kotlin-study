package ro.ccar.java.examples;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductExample {

    public static List<Product> products = List.of(
        new Product("Lollipop", "sweets", 1.2, 321),
        new Product("Broccoli", "vegetable", 1.8, 5)
    );

    public static void main(String[] args) {
        Map<String, List<Product>> top3RevenueByCategoryJ =
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::category,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(
                                                        (Product p) -> p.price() * p.sold()
                                                )
                                                        .reversed())
                                                .limit(3)
                                                .toList()
                                )
                        ));
    }
}



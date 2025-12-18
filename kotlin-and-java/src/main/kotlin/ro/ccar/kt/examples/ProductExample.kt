package ro.ccar.kt.examples

import ro.ccar.java.examples.Product
import ro.ccar.java.examples.ProductExample


val top3RevenueByCategoryK: Map<String, List<Product>> =
    ProductExample.products
        .groupBy { it.category }
        .mapValues { (_, list) -> list.sortedByDescending { it.price * it.sold }.take(3) }
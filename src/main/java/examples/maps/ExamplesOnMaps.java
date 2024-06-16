package examples.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ExamplesOnMaps {

    public static void main(String[] args) {


      //  exampleOne();

      //  filterBasedOnPrice();

        mergeTwoMaps();

    }


    public static void exampleOne() {
        Map<String, Integer> productPrices = new HashMap<>();
        productPrices.put("Laptop", 1200);
        productPrices.put("SmartPhone", 800);
        productPrices.put("Tablet", 600);

        productPrices.forEach((product, price) -> System.out.println(product + " costs " + price));
    }

    public static void filterBasedOnPrice() {
        Map<String, Integer> productPrices = new HashMap<>();
        productPrices.put("Laptop", 1200);
        productPrices.put("SmartPhone", 800);
        productPrices.put("Tablet", 400);
        productPrices.put("Phone", 150);

        Map<String, Integer> expensiveProducts = productPrices.entrySet().stream()
                .filter(entry -> entry.getValue() > 500)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        expensiveProducts.forEach((product, price) -> System.out.println(product + " costs " + price));
    }

    public static void mergeTwoMaps(){

        Map<String,Integer> map1 = new HashMap<>();
        map1.put("Laptop", 1200);
        map1.put("SmartPhone", 800);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("Tablet", 400);
        map2.put("Phone", 150);

        map2.forEach((key,value) -> map1.merge(key,value,Integer::sum));

        map1.forEach((product, price) -> System.out.println(product + " costs " + price));

    }
}

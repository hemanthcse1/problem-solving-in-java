package examples.daily.february;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }

    public void add(int num) {
        if (num == 0) {

            prefixProducts.clear();
            prefixProducts.add(1);
        } else {

            prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProducts.size();
        if (k >= size) {
            return 0;
        }
        return prefixProducts.get(size - 1) / prefixProducts.get(size - 1 - k);
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();


        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);

        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));

        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));
    }
}

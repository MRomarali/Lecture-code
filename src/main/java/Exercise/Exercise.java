package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Action{
    void execute(Product p);
}
interface  Conditional{
    boolean test(Product p);
}
public class Exercise {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("spam", 10.90, 0),
                new Product("Ham", 40.50, 7),
                new Product("Laptop", 3990, 5),
                new Product("Java book", 140.99, 6),
                new Product("Boat", 140000, 1)
        ));
        testAndExecute(
                products,
                p -> p.getStock() == 0,
                p -> System.out.println(p)

        );
        testAndExecute(products, p -> p.getProductName().toUpperCase().startsWith("B"), p -> System.out.println(p));
        testAndExecute(products, p -> p.getPrice() > 100 && p.getPrice() < 150, p -> System.out.println(p));
        testAndExecute(products, p -> p.getStock() > 10 && p.getStock() > 0, p -> p.setPrice(p.getPrice() * 1.5));

        products.forEach(p -> System.out.println(p));
    }
    public static void testAndExecute(List<Product> products, Conditional conditional, Action action){
        for (Product p : products){
            if (conditional.test(p)){
                action.execute(p);
            }
        }
    }
}

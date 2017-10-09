package workshop.db;

import workshop.models.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static Repository repository = new Repository();
    private Map<Integer, Product> productDB;
    private Repository() {
        this.productDB = new HashMap<>();
    }

    public static Repository getInstance() {
        return repository;
    }

    public void persist(Product product) {
        this.productDB.putIfAbsent(product.getId(), product);
    }

    public void persist(Collection<Product> products) {
        for (Product product: products) {
            this.persist(product);
        }
    }

    public Collection<Product> getAll() {
        return this.productDB.values();
    }
}

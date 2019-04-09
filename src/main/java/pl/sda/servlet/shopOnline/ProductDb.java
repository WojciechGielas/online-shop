package pl.sda.servlet.shopOnline;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductDb {
    private static ProductDb db;
    private static long currentId = 3L;

    private List<Product> products;

    public ProductDb() {
        this.products = new LinkedList<>();
        this.products.add(new Product(1L, LocalDateTime.now(), "Audi A6", "samochód osobowy", 60900, "sedan", 5,"url=wybranySamochod.png"));
        this.products.add(new Product(2L, LocalDateTime.now(), "BMW", "samochód osobowy", 70500, "kombi", 4, null));
        this.products.add(new Product(3L, LocalDateTime.now(), "Fiat Punto", "samochód osobowy", 39400, "hatchback", 3, null));
        this.products.add(new Product(4L, LocalDateTime.now(), "Dacia Dokker", "samochód ciezarowy", 42400, "ciężarowy", 2, null));
    }

    public static ProductDb getInstance() {
        if (db == null) {
            db = new ProductDb();
        }
        return db;
    }

    public List<Product> getProducts() {
        return products;
    }

    public long addNewProduct(final String name, final String description, final long price, final String category, final int quantity, final String pictureUrl) {
        long productId = currentId++;
        Product newProduct = new Product(productId, LocalDateTime.now(), name, description, price, category, quantity, pictureUrl);
        this.products.add(newProduct);
        return productId;
    }
    public Optional<Product> getProductById(final long id){
        return getProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
}

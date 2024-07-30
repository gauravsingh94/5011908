import java.util.HashMap;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class Inventory {
    private HashMap<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, Product updatedProduct) {
        products.put(productId, updatedProduct);
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public void printInventory() {
        for (Product product : products.values()) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
            System.out.println("------------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product(1, "Product 1", 10, 9.99);
        Product product2 = new Product(2, "Product 2", 20, 19.99);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.printInventory();

        Product updatedProduct = new Product(1, "Product 1 Updated", 15, 12.99);
        inventory.updateProduct(1, updatedProduct);

        inventory.printInventory();

        inventory.deleteProduct(2);

        inventory.printInventory();
    }
}

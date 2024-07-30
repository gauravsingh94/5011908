public class Main {
    public static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }
    }

    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == targetId) {
                return mid;
            } else if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = new Product[] {
                new Product(1, "Product 1", "Category 1"),
                new Product(2, "Product 2", "Category 2"),
                new Product(3, "Product 3", "Category 3"),
                new Product(4, "Product 4", "Category 4"),
                new Product(5, "Product 5", "Category 5")
        };

        int targetId = 3;

        int resultLinear = linearSearch(products, targetId);
        System.out.println("Linear Search Result: " + resultLinear);

        // Sort products for binary search
        java.util.Arrays.sort(products, (a, b) -> a.getProductId() - b.getProductId());

        int resultBinary = binarySearch(products, targetId);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}


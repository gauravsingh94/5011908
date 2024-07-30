public class Main {
    public static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }

    public static class BubbleSort {
        public static void sortOrders(Order[] orders) {
            for (int i = 0; i < orders.length - 1; i++) {
                for (int j = 0; j < orders.length - i - 1; j++) {
                    if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                        // Swap orders[j] and orders[j + 1]
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static class QuickSort {
        public static void sortOrders(Order[] orders) {
            quickSort(orders, 0, orders.length - 1);
        }

        private static void quickSort(Order[] orders, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(orders, low, high);
                quickSort(orders, low, pivotIndex - 1);
                quickSort(orders, pivotIndex + 1, high);
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            // Select pivot element
            Order pivot = orders[high];

            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (orders[j].getTotalPrice() < pivot.getTotalPrice()) {
                    i++;
                    // Swap orders[i] and orders[j]
                    Order temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }

            // Swap orders[i + 1] and orders[high]
            Order temp = orders[i + 1];
            orders[i + 1] = orders[high];
            orders[high] = temp;

            return i + 1;
        }
    }

    public static void main(String[] args) {
        Order[] orders = new Order[] {
                new Order(1, "Customer 1", 100.0),
                new Order(2, "Customer 2", 50.0),
                new Order(3, "Customer 3", 200.0),
                new Order(4, "Customer 4", 150.0),
                new Order(5, "Customer 5", 80.0)
        };

        System.out.println("Before Sorting:");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }

        BubbleSort.sortOrders(orders);

        System.out.println("After Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }

        QuickSort.sortOrders(orders);

        System.out.println("After Quick Sort:");
        for (Order order : orders) {
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }
    }
}


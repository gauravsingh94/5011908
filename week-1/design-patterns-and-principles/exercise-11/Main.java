public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = customerService.findCustomerById(1);
        System.out.println(customer.getName());
    }
}

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

interface CustomerRepository {
    Customer findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Simulate finding a customer by ID
        return new Customer(id, "Gaurav Singh");
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(int id) {
        return customerRepository.findCustomerById(id);
    }
}


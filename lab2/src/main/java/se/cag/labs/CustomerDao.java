package se.cag.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao {

    List<Customer> customers = new ArrayList<>();

    public boolean update(Customer customer) {
        System.out.println("Real CustomerDao is updating customer...");

        //TODO: fixa så att inte exists används
        Optional<Customer> first = customers.stream()
                .filter(c -> c.getCustomerId().equals(customer.getCustomerId()))
                .findFirst();

        if(first.isPresent()) {
            customers.remove(first.get());
        }
            return customers.add(customer);
    }

    public boolean exists(String customerId) {
        System.out.println("Real CustomerDao exist...");

        return customers.stream()
                .anyMatch(customer -> customer.getCustomerId().equals(customerId));

    }

    public boolean save(Customer customer) {
        System.out.println("Real CustomerDao is saving customer...");

        return customers.add(customer);
    }

    public boolean delete(Customer customer) {
        System.out.println("Real CustomerDao is deleting customer...");

        return customers.remove(customer);
    }

    public Optional<Customer> get(String customerId) {
        System.out.println("Real CustomerDao is getting customer...");
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst();
    }
}

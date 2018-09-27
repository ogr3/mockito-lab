package se.cag.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDao {

    private static final Logger LOG = Logger.getLogger(CustomerDao.class.getName());

    List<Customer> customers = new ArrayList<>();

    public boolean update(Customer customer) {
        LOG.log(Level.INFO, "Real CustomerDao: updating customer...");

        Optional<Customer> first = customers.stream()
                .filter(c -> c.getCustomerId().equals(customer.getCustomerId()))
                .findFirst();

        if(first.isPresent()) {
            customers.remove(first.get());
        }
            return customers.add(customer);
    }

    public boolean exists(String customerId) {
        LOG.log(Level.INFO, "Real CustomerDao: customer exists...");

        return customers.stream()
                .anyMatch(customer -> customer.getCustomerId().equals(customerId));

    }

    public boolean save(Customer customer) {
        LOG.log(Level.INFO, "Real CustomerDao: saving customer...");

        return customers.add(customer);
    }

    public boolean delete(Customer customer) {
        LOG.log(Level.INFO, "Real CustomerDao: deleting customer...");

        return customers.remove(customer);
    }

    public Optional<Customer> get(String customerId) {
        LOG.log(Level.INFO, "Real CustomerDao: getting customer...");
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(customerId))
                .findFirst();
    }
}

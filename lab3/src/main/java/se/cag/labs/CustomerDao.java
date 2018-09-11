package se.cag.labs;

import java.util.Arrays;
import java.util.List;

public class CustomerDao {

    List existingCustomerIds = Arrays.asList("1122333", "343434", "555555");

    public boolean update(Customer customer) {
        System.out.println("Real CustomerDao is updating customer...");
        return true;
    }

    public boolean exists(String phoneNumber) {
        return existingCustomerIds.contains(phoneNumber);
    }

    public boolean save(Customer customer) {
        System.out.println("Real CustomerDao is saving customer...");
        return true;
    }

    public boolean delete(Customer customer) {
        System.out.println("Real CustomerDao is deleting customer...");
        return true;
    }
}

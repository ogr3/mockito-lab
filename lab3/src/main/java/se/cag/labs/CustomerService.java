package se.cag.labs;

import javax.inject.Inject;

public class CustomerService {

    @Inject
    private CustomerDao customerDao;

    public boolean addCustomer(Customer customer){

        if(customerDao.exists(customer.getCustomerId())){
            return false;
        }

        return customerDao.save(customer);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}

package se.cag.labs.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import se.cag.labs.Customer;
import se.cag.labs.CustomerDao;
import se.cag.labs.CustomerService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CustomerServiceDemo {

    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Tests that mocks the Dao
     */
    @Test
    public void testAddCustomer_shouldReturnFalseIfCustomerExists() {

        when(daoMock.exists(anyString())).thenReturn(true);
        when(daoMock.save(any(Customer.class))).thenReturn(true);

        boolean result = service.addCustomer(new Customer("Ross", "1122333"));

        assertFalse(result);
    }

    /**
     * Tests that mocks the Dao
     */
    @Test
    public void testAddCustomer_shouldReturnTrueIfCustomerDoesntExist() {

        when(daoMock.exists(anyString())).thenReturn(false);
        when(daoMock.save(any(Customer.class))).thenReturn(true);

        boolean result = service.addCustomer(new Customer("Ross", "1122333"));

        assertTrue(result);
    }

    /**
     * Test that verifies that methods has been called
     */
    @Test
    public void verifyThatMethodIsCalled() {

        when(daoMock.save(any(Customer.class))).thenReturn(true);

        Customer customer = new Customer("Ross", "1122333");
        assertTrue(service.addCustomer(customer));

        //verify that the save method has been invoked
        verify(daoMock).save(any(Customer.class));
        //the above is similar to :  verify(daoMock, times(1)).save(any(Customer.class));

        //verify that the exists method is invoked one time
        verify(daoMock, times(1)).exists(anyString());

        //verify that the delete method has never been  invoked
        verify(daoMock, never()).delete(any(Customer.class));
    }
}
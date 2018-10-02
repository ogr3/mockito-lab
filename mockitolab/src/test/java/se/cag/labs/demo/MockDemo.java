package se.cag.labs.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import se.cag.labs.Customer;
import se.cag.labs.CustomerDao;
import se.cag.labs.CustomerService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockDemo {

    public static final String ROSS = "Ross";
    public static final String CUSTOMER_ID = "1122333";
    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        // Initiate mocks
    }

    /**
     * Tests that mocks the Dao
     */
    @Test
    public void testAddCustomer_shouldReturnFalseIfCustomerExists() {

        // mocks

        boolean result = service.addCustomer(new Customer(ROSS, CUSTOMER_ID));

        assertFalse(result);
    }

    /**
     * Tests that mocks the Dao
     */
    @Test
    public void testAddCustomer_shouldReturnTrueIfCustomerDoesntExist() {

        // mocks

        boolean result = service.addCustomer(new Customer(ROSS, CUSTOMER_ID));

        assertTrue(result);
    }
}
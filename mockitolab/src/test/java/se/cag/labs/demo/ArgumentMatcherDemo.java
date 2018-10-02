package se.cag.labs.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import se.cag.labs.Customer;
import se.cag.labs.CustomerDao;
import se.cag.labs.CustomerService;

import static org.junit.jupiter.api.Assertions.*;

public class ArgumentMatcherDemo {

    private static final String NISSE = "Nisse";
    private static final String BAD_CUSTOMER_ID = "0313332333";
    private static final String CUSTOMER_ID = "1122333";

    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCustomer_shouldReturnFalseIfCustomerExists() {

        // Mocks with argument matchers on customerId and customer

        boolean result = service.addCustomer(new Customer(NISSE, CUSTOMER_ID));

        assertTrue(result);
    }

    @Test
    public void shouldThrowException_whenBadPrefix() {

        // Mocks with argument matcher startsWith("")

        try {
            service.addCustomer(new Customer(NISSE, BAD_CUSTOMER_ID));
            fail("Men va fan!");
        } catch(Exception e) {
            assertEquals(RuntimeException.class, e.getClass());
        }

        //TODO: Gör även samma sak fast med assertThrows
    }
}

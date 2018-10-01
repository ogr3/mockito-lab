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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.when;

public class ArgumentMatcherDemo {
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

        when(daoMock.exists(anyString())).thenReturn(false);
        when(daoMock.save(any(Customer.class))).thenReturn(true);


        boolean result = service.addCustomer(new Customer("Nisse", "1122333"));

        assertTrue(result);
    }

    @Test
    public void shouldThowException_ifStartWith031() {

        when(daoMock.exists(startsWith("031"))).thenThrow(RuntimeException.class);

        try {
            service.addCustomer(new Customer("Ross", "0313332333"));
            fail("Men va fan!");
        } catch(Exception e) {
            assertEquals(RuntimeException.class, e.getClass());
        }

        //TODO: Gör även samma sak fast med assertThrows
    }



}

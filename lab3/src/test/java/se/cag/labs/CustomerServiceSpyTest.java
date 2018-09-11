package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CustomerServiceSpyTest {

    @Spy
    private CustomerDao daoSpy;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test that runs verify on a 'real' object.
     * NOTE: that the print outs from the real object is present on the system out.
     *
     */
    @Test
    public void test() {

        Customer customer = new Customer("Ross", "123456");

        assertTrue(service.addCustomer(customer));

        verify(daoSpy).save(any(Customer.class));

        verify(daoSpy, times(1)).exists(anyString());

        verify(daoSpy, never()).delete(any(Customer.class));
    }
}

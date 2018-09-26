package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CustomerServiceSpyTest {

    @Spy
    private CustomerDao daoSpy;

    @InjectMocks
    private CustomerService service;

    Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("Ross", "123456");
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Övning 4. Test av verify med Spy.
     *
     * Testa att uppdatera en existerande kund och att CustomerDao.update() har anropats.
     * Verifiera vilka metoder som anropats eller inte och hur många gånger.
     * daoSpy.save, daoSpy.update och daoSpy.exists
     *
     *
     *
     */
    @Test
    public void testUpdateCustomer() {

        service.addCustomer(new Customer("addName", "1122333"));
        service.updateCustomer(new Customer("updateName", "1122333"));

        verify(daoSpy, times(2)).exists("1122333");
        verify(daoSpy).update(any(Customer.class));
        verify(daoSpy, times(1)).save(any(Customer.class));

        Optional<Customer> customer = service.getCustomer("1122333");
        assertTrue(customer.isPresent());
        assertEquals("updateName", customer.get().getName());
    }

    /**
     * Övning 5. Test av verify med Spy med mock.
     *
     * Uppdatera en befintlig kund.
     * Testa att uppdatera mocka exists på daoSpy.exists
     *
     *
     *
     */
    @Test
    public void testUpdateCustomerWithMock() {

        doReturn(true).when(daoSpy).exists("1122333");
        service.updateCustomer(new Customer("updateName", "1122333"));

        verify(daoSpy, times(1)).exists("1122333");
        verify(daoSpy).update(any(Customer.class));
        verify(daoSpy, times(0)).save(any(Customer.class));

        Optional<Customer> customer = service.getCustomer("1122333");
        assertTrue(customer.isPresent());
        assertEquals("updateName", customer.get().getName());
    }
    
    /**
     * Test that runs verify on a 'real' object.
     * NOTE: that the print outs from the real object is present on the system out.
     *
     */
    @Test
    public void test() {

        //Customer customer = new Customer("Ross", "123456");

        assertTrue(service.addCustomer(customer));

        verify(daoSpy).save(any(Customer.class));
        //the above is similar to :  verify(daoSpy, times(1)).save(any(Customer.class));

        verify(daoSpy, times(1)).exists(anyString());

        verify(daoSpy, never()).delete(any(Customer.class));
    }

    @Test
    public void spyWithMock() {
        Customer updateCustomer = new Customer("Joe", "555555");

        doReturn(true).when(daoSpy).save(updateCustomer);

        assertTrue(service.updateCustomer(updateCustomer));
    }
}

package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


public class ArgumentCaptureTest {

    @Spy
    private CustomerDao daoSpy;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test av Argument capture.
     *
     * Skapa ett Customerobjekt och verifiera att det är just det objektet som används
     * i CustomerDao.save() genom att använda ArgumentCapture.
     */
    @Test
    public void addCustomer() {
        Customer customer = new Customer("Rosco", "1234567");
        service.addCustomer(customer);

        ArgumentCaptor<Customer> argumentCaptor = ArgumentCaptor.forClass(Customer.class);

        verify(daoSpy).save(argumentCaptor.capture());
        assertEquals(customer, argumentCaptor.getValue());
        assertEquals(customer, service.getCustomer(customer.getCustomerId()).get());
    }
}

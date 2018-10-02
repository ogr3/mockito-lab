package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


public class ArgumentCaptorTest {

    private static final String CUSTOMER_ID = "1234567";
    private static final String NAME = "Rosco";

    @Spy
    private CustomerDao daoSpy;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Övning 7. Test av Argument captor.
     *
     * Skapa ett objekt av Customer och verifiera att det är just det objektet som används
     * i CustomerDao.save(). Använd ArgumentCaptor.
     */
    @Test
    public void addCustomer() {
        Customer customer = new Customer(NAME, CUSTOMER_ID);
        service.addCustomer(customer);

    }
}

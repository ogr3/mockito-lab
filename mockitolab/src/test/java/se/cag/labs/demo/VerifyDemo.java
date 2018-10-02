package se.cag.labs.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import se.cag.labs.Customer;
import se.cag.labs.CustomerDao;
import se.cag.labs.CustomerService;

import static org.mockito.Mockito.when;

public class VerifyDemo {

    private static final String ROLAND = "Roland";
    private static final String CUSTOMER_ID = "123456";

    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }



    /**
     * Test av verify.
     *
     * Testa att uppdatera en existerande kund och att CustomerDao.update() har anropats.
     *
     */
    @Test
    public void demoVerify() {

        when(daoMock.exists(CUSTOMER_ID)).thenReturn(true);

        service.updateCustomer(new Customer(ROLAND, CUSTOMER_ID));

    }
}

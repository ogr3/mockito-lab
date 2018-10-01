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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class VerifyDemo {

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
     *
     *
     */
    @Test
    public void demoVerify() {


    }

}

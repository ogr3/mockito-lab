package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.*;

public class VerifyTest {

    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    /**
     * Övning 4a. Test av verify.
     *
     * Testa att uppdatera en existerande kund och att CustomerDao.update() har anropats.
     * Kontrollera att inte save() anropas när man gör en update
     *
     *
     */
    @Test
    public void testUpdateCustomer() {

        when(daoMock.exists(anyString())).thenReturn(true);

        boolean result = service.updateCustomer(new Customer("Ross", "1122333"));

        verify(daoMock).update(any(Customer.class));
        verify(daoMock, times(0)).save(any(Customer.class));
    }

    /**
     * Övning 4b. Test av verify.
     *
     *
     *
     *
     */

}

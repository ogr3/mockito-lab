package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
     * Test av Argument matcher.
     *
     * Testa att ett exception kastas om en kund har ett id som börjar på '031'.
     *
     * Det finns 2 sätt att testa exceptions:
     *  - try/catch
     *  - assertThrows (JUnit 5)
     */
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



    /**
     * Test av verify.
     *
     * Testa att uppdatera en existerande kund och att CustomerDao.update() har anropats.
     *
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

}

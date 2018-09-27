package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class SpyWithMockObjectTest {

    private static final String NAME = "Johnny";
    private static final String UPDATED_NAME = "Johnnie";
    private static final String CUSTOMER_ID = "1122333";

    @Spy
    private CustomerDao daoSpy;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * ÖVNING 5. Testar att det går att uppdatera en existerande kund
     *
     * Ta hjälp av Spy för att testa att metoderna i CustomerDao anropas som det är tänkt.
     *
     * OBS!
     * I detta test ska du se till att metoden CustomerDao.exists() inte exekveras. Utskriften ska alltså inte finnas
     * med i loggen i detta test.
     *
     * Jämför med ÖVNING 4 där man man i loggen se "Real CustomerDao exist...."
     *
     *
     * Verifiera att metoderna anropas rätt antal gånger:
     *
     *  - daoSpy.exists() - ? gånger
     *  - daoSpy.update() - ? gånger
     *  - daoSpy.save() - ? gånger
     *
     *  Kontrollera även att Customer har det uppdaterade namnet.
     *
     */
    @Test
    public void testUpdateCustomerWithMock() {

        new Customer(NAME, CUSTOMER_ID);
        doReturn(true).when(daoSpy).exists(CUSTOMER_ID);
        service.updateCustomer(new Customer(UPDATED_NAME, CUSTOMER_ID));

        verify(daoSpy, times(1)).exists(CUSTOMER_ID);
        verify(daoSpy).update(any(Customer.class));
        verify(daoSpy, times(0)).save(any(Customer.class));

        Optional<Customer> customer = service.getCustomer(CUSTOMER_ID);
        assertTrue(customer.isPresent());
        assertEquals(UPDATED_NAME, customer.get().getName());

    }
}

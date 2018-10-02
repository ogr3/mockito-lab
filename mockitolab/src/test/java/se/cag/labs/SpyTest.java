package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class SpyTest {

    private static final String NAME = "Johnny";
    private static final String UPDATED_NAME = "Johnnie";
    private static final String CUSTOMER_ID = "1122333";

    @Spy
    private CustomerDao daoSpy;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * ÖVNING 5. Testar att det går att uppdatera en existerande kund.
     *
     * Ta hjälp av Spy för att testa att metoderna i CustomerDao anropas som det är tänkt.
     *
     * Verifiera att metoderna anropas och att de anropas rätt antal gånger:
     *
     *  - daoSpy.exists() - ? gånger
     *  - daoSpy.update() - ? gånger
     *  - daoSpy.save() - ? gånger
     *
     * Kontrollera även att en uppdaterad Customer har fått rätt namn.
     *
     */
    @Test
     void testUpdateCustomer() {

        service.addCustomer(new Customer(NAME, CUSTOMER_ID));
        service.updateCustomer(new Customer(UPDATED_NAME, CUSTOMER_ID));

    }


    /**
     * ÖVNING 6. Testar att det går att uppdatera en existerande kund
     *
     * Ta hjälp av Spy för att testa att metoderna i CustomerDao anropas som det är tänkt.
     *
     * OBS!
     * I detta test ska du se till att metoden CustomerDao.exists() inte exekveras. Utskriften ska alltså inte finnas
     * med i loggen i detta test.
     *
     * Jämför med ÖVNING 5 där man man i loggen se "Real CustomerDao exist...."
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

        service.updateCustomer(new Customer(UPDATED_NAME, CUSTOMER_ID));
    }
}

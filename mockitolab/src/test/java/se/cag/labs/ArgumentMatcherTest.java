package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ArgumentMatcherTest {

    private static final String NOT_ACCEPTED_CUSTOMER_ID = "0313332333";
    private static final String NON_ACCEPTABLE_CUSTOMER_PREFIX = "031";
    private static final String NAME = "Ross";

    @Spy
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * ÖVNING 3A - Test av Argument matcher.
     *
     * Testa/fejka att ett RuntimeException kastas om man försöker uppdatera en kund har ett id som börjar på '031'.
     *
     * Det finns 2 sätt att testa exceptions:
     *  - try/catch
     *  - assertThrows (JUnit 5)
     *
     *  Avvänd try/catch i detta test.
     */
    @Test
    public void shouldThrowException_a() {

        try {
            service.addCustomer(new Customer(NAME, NOT_ACCEPTED_CUSTOMER_ID));
            fail("If this row is executed....an exception is never thrown!");
        } catch(Exception e) {
            assertEquals(RuntimeException.class, e.getClass());
        }
    }

    /**
     * ÖVNING 3B - Test av Argument matcher.
     *
     * Testa att ett NullPointerException kastas om man försöker uppdatera en kund med ett objekt som är null
     * (service.addCustomer(null).
     *
     * Det finns 2 sätt att testa exceptions:
     *  - try/catch
     *  - assertThrows (JUnit 5)
     *
     *  Använd assertThrows i detta test.
     */
    @Test
    public void shouldThrowException_b() {

    }

    /**
     * ÖVNING 3C - Test av Argument matcher.
     *
     * Testa att ett exception kastas oavsett vilket kundid som används.
     *
     * Det finns 2 sätt att testa exceptions:
     *  - try/catch
     *  - assertThrows (JUnit 5)
     *
     *  Lös uppgiften 'like a pro'.
     */
    @Test
    public void shouldThrowException_c() {

        try {
            service.addCustomer(new Customer("Ross", NOT_ACCEPTED_CUSTOMER_ID));
            fail("If this row is executed....an exception is never thrown!");
        } catch(Exception e) {
            assertEquals(RuntimeException.class, e.getClass());
        }
    }
}

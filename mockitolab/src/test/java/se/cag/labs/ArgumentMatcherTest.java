package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.when;


public class ArgumentMatcherTest {

    private static final String NOT_ACCEPTED_CUSTOMER_ID = "0313332333";
    private static final String NON_ACCEPTABLE_CUSTOMER_PREFIX = "031";
    public static final String NAME = "Ross";

    @Spy
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * ÖVNING 3a - Test av Argument matcher.
     *
     * Testa/fejka att ett exception kastas om en kund har ett id som börjar på '031'.
     *
     * Det finns 2 sätt att testa exceptions:
     *  - try/catch
     *  - assertThrows (JUnit 5)
     *
     *  Avvänd try/catch i detta test.
     */
    @Test
    public void shouldThrowException_a() {

        when(daoMock.exists(startsWith(NON_ACCEPTABLE_CUSTOMER_PREFIX))).thenThrow(RuntimeException.class);

        try {
            service.addCustomer(new Customer(NAME, NOT_ACCEPTED_CUSTOMER_ID));
            fail("If this row is executed....an exception is never thrown!");
        } catch(Exception e) {
            assertEquals(RuntimeException.class, e.getClass());
        }
    }

    /**
     * ÖVNING 3b - Test av Argument matcher.
     *
     * Testa att ett NPE (NullPointerException) kastas om en man försöker uppdatera en kund med ett objekt som är null
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
        assertThrows(NullPointerException.class, () -> service.addCustomer(null));
    }

    /**
     * ÖVNING 3c - Test av Argument matcher.
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

        when(daoMock.exists(startsWith(NON_ACCEPTABLE_CUSTOMER_PREFIX))).thenThrow(RuntimeException.class);

        try {
            service.addCustomer(new Customer("Ross", NOT_ACCEPTED_CUSTOMER_ID));
            fail("If this row is executed....an exception is never thrown!");
        } catch(Exception e) {
            assertEquals(RuntimeException.class, e.getClass());
        }
    }
}

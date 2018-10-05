package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.when;

public class ArgumentMatcherTest {

  private static final String NOT_ACCEPTED_CUSTOMER_ID = "0313332333";
  private static final String NON_ACCEPTABLE_CUSTOMER_PREFIX = "031";
  private static final String NAME = "Ross";

  @Spy private CustomerDao daoMock;

  @InjectMocks private CustomerService service;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    when(daoMock.exists(startsWith(NON_ACCEPTABLE_CUSTOMER_PREFIX))).thenReturn(false);
  }

  /**
   * ÖVNING 3A - Test av Argument matcher.
   *
   * <p>Testa/fejka att ett RuntimeException kastas om man försöker uppdatera en kund har ett id som
   * börjar på '031'.
   *
   * <p>Det finns 2 sätt att testa exceptions: - try/catch - assertThrows (JUnit 5)
   *
   * <p>Avvänd try/catch i detta test.
   */
  @Test
  public void shouldThrowException_a() {
    when(daoMock.exists(startsWith(NON_ACCEPTABLE_CUSTOMER_PREFIX)))
        .thenThrow(RuntimeException.class);

    try {
      service.addCustomer(new Customer(NAME, NOT_ACCEPTED_CUSTOMER_ID));
      fail("If this row is executed....an exception is never thrown!");
    } catch (Exception e) {
      assertEquals(RuntimeException.class, e.getClass());
    }
  }

  /**
   * ÖVNING 3B - Test av Argument matcher.
   *
   * <p>Testa att ett NullPointerException kastas om man försöker uppdatera en kund med ett objekt
   * som är null (service.addCustomer(null).
   *
   * <p>Det finns 2 sätt att testa exceptions: - try/catch - assertThrows (JUnit 5)
   *
   * <p>Använd assertThrows i detta test.
   */
  @Test
  public void shouldThrowException_b() {
    assertThrows(
        NullPointerException.class,
        () -> {
          service.addCustomer(null);
        });
  }

  /**
   * ÖVNING 3C - Test av Argument matcher.
   *
   * <p>Testa att ett exception kastas oavsett vilket kundid som används.
   *
   * <p>Det finns 2 sätt att testa exceptions: - try/catch - assertThrows (JUnit 5)
   *
   * <p>Lös uppgiften 'like a pro'.
   */
  @Test
  public void shouldThrowException_c() {

    when(daoMock.exists(anyString())).thenThrow(RuntimeException.class);

    try {
      service.addCustomer(new Customer("Ross", NOT_ACCEPTED_CUSTOMER_ID));
      fail("If this row is executed....an exception is never thrown!");
    } catch (Exception e) {
      assertEquals(RuntimeException.class, e.getClass());
    }
  }
}

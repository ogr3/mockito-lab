package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class VerifyTest {

  private static final String CUSTOMER_ID = "1122333";
  private static final String NAME = "Ross";

  @Mock private CustomerDao daoMock;

  @InjectMocks private CustomerService service;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Övning 4A. Test av verify.
   *
   * <p>Testa att uppdatera en existerande kund och att CustomerDao.update() har anropats.
   * Kontrollera även att save() INTE anropas när man gör en update.
   */
  @Test
  public void updateCustomer_shouldCallCorrectMethods() {
    when(daoMock.exists(anyString())).thenReturn(false);

    service.updateCustomer(new Customer(NAME, CUSTOMER_ID));
    verify(daoMock, times(1)).update(any());
    verify(daoMock, times(0)).save(any());
  }

  /**
   * Övning 4B. Test av verify.
   *
   * <p>Testa att lägga till en ny kund service.addCustomer() och verifiera att -
   * CustomerDao.exists() anropas - CustomerDao.save() anropas
   */
  @Test
  public void saveCustomer_shouldCallCorrectMethods() {

    service.addCustomer(new Customer(NAME, CUSTOMER_ID));
    verify(daoMock, times(1)).exists(anyString());
    verify(daoMock, times(1)).save(any());
  }
}

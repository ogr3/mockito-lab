package se.cag.labs.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class CarTest {

  @Mock private Engine engine;
  @Mock private FuelTank fuelTank;

  @InjectMocks private Car car;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    when(fuelTank.getFuel()).thenReturn(100);
    when(engine.isRunning()).thenReturn(true);
  }

  /**
   * ÖVNING 1 - testa att bilen kan startas utan att exceptions kastas.
   *
   * <p>Byt ut FuelTank mot mockade objekt. Använd inte annotering för detta.
   */
  @Test
  void shouldStart_WithoutExceptions_1() {

    // Car car = new Car(engine, fuelTank);

    car.start();
  }

  /**
   * ÖVNING 2 - testa att bilen kan startas utan att exceptions kastas.
   *
   * <p>Byt ut Engine och FuelTank mot mockade objekt. Använd annotering för detta.
   */
  @Test
  void shouldStart_WithoutExceptions_2() {

   // Car car = new Car(engine, fuelTank);

    car.start();
  }
}

package se.cag.labs.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class CarTest {

  private Engine engine = Mockito.mock(Engine.class);
  private FuelTank fuelTank = Mockito.mock(FuelTank.class);

  @BeforeEach
  public void setup() {
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

    Car car = new Car(engine, fuelTank);

    car.start();
  }

  /**
   * ÖVNING 2 - testa att bilen kan startas utan att exceptions kastas.
   *
   * <p>Byt ut Engine och FuelTank mot mockade objekt. Använd annotering för detta.
   */
  @Test
  void shouldStart_WithoutExceptions_2() {

    Car car = new Car(engine, fuelTank);

    car.start();
  }
}

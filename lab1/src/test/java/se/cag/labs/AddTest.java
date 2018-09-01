package se.cag.labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Project:mockitolab
 * User: fredrik
 * Date: 2018-08-29
 * Time: 19:03
 */
public class AddTest {
  @Mock
  Add add;

  @BeforeEach
  public void setup(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void AddShouldReturnCorrectSum(){
    // when
    Mockito.when(add.add(3,5)).thenReturn(8);
    Mockito.when(add.add(5,3)).thenReturn(9);

    int sum = this.add.add(3, 5);

    assertEquals(8,sum);

    int failSum = this.add.add(5,3);
    assertNotEquals(8,failSum);


  }
}

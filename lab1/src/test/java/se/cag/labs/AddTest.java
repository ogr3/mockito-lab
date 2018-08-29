package se.cag.labs;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Project:mockitolab
 * User: fredrik
 * Date: 2018-08-29
 * Time: 19:03
 */
public class AddTest {
  @Mock
  Add add;

  @Before
  public void setup(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void AddShouldReturnCorrectSum(){
    // when
    Mockito.when(add.add(3,5)).thenReturn(8);

    int sum = this.add.add(3, 5);

    assertEquals(8,sum);


  }
}

package se.cag.labs.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

  @Test
  public void badExampleOfMock() {
    List<String> lista = new ArrayList<>();
    lista.add("ett dåligt exempel");
    lista.add("ännu ett dåligt exempel");
    List<String> listMock = mock(List.class);
    when(listMock.toArray()).thenReturn(lista.toArray());
    assertTrue(Arrays.equals(listMock.toArray(),lista.toArray()));
  }
}

package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sviatoslav on 08.12.2016.
 */
public class PointTests {

  @Test
  public void testDistance(){
    Point a = new Point(5, 9);
    Point b = new Point(3, 5);
    Assert.assertEquals(a.distance(b), 4.47213595499958);
  }
}

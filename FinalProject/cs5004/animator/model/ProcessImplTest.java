package cs5004.animator.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents tests for processImpl.
 */
public class ProcessImplTest {

  Rectangle rect1;
  Ellipse elli1;
  ProcessImpl processOne;

  /**
   * Sets up some instances.
   */
  @org.junit.Before
  public void setUp() {
    rect1 = new Rectangle(0, 0, 10, 10, 10, 10, 10, "R1", 10, 20);
    elli1 = new Ellipse(0, 0, 10, 10, 10, 10, 10, "E1", 10, 30);
    processOne = new ProcessImpl();
    processOne.addShape(rect1);
    processOne.addShape(elli1);
  }

  /**
   * Test for testing whether has this shape.
   */
  @org.junit.Test
  public void hasShape() {
    assertTrue(processOne.hasShape("E1"));
    processOne.removeShape("E1");
    assertFalse(processOne.hasShape("E1"));
  }

  /**
   * Tests getshapes method.
   */
  @org.junit.Test
  public void getShapes() {
    List<AbstractShape> list1;
    list1 = processOne.getShapes();
    assertEquals(list1.size(), 2);
    assertEquals(10, list1.get(0).getAppearTime());


  }

  /**
   * Tests getCertainShape method.
   */
  @org.junit.Test
  public void getCertainShape() {
    AbstractShape shapeTestOne;
    shapeTestOne = processOne.getCertainShape("E1");
    assertEquals(30, shapeTestOne.getDisappearTime());

  }

  /**
   * Tests getMothions method.
   */
  @org.junit.Test
  public void getMotions() {
    Ellipse elli2;
    elli2 = new Ellipse(0, 0, 10, 10, 10, 10, 10, "E2", 10, 30);
    processOne.addShape(elli2);
    assertTrue(processOne.hasShape("E2"));
    processOne.addMove(elli2, 0, 0, 2, 2, 11, 12);
    processOne.addMove(elli2, 2, 2, 4, 2, 14, 15);
    processOne.addMove(elli2, 2, 2, 4, 2, 12, 13);
    processOne.addChangeColor(elli2, 0, 0, 0, 3, 3, 3, 14, 15);

    assertEquals(processOne.getMotions("E2").get(0).getUniqueCode(), "E2");
  }

  /**
   * Tests addShape method.
   */
  @org.junit.Test
  public void addShape() {
    Ellipse elli2;
    elli2 = new Ellipse(0, 0, 10, 10, 10, 10, 10, "E2", 10, 30);
    processOne.addShape(elli2);
    assertTrue(processOne.hasShape("E2"));
  }

  /**
   * Tests addMove method.
   */
  @org.junit.Test
  public void addMove() {
    assertEquals("E1", elli1.getUniqueCode());
    processOne.addMove(elli1, 0, 0, 1, 1, 13, 18);
    ArrayList<AbstractMotion> motionTestOne;
    motionTestOne = processOne.getMotions("E1");
    int actual = motionTestOne.get(0).getStartTime();
    assertEquals(13, actual);
    assertEquals("R1", rect1.getUniqueCode());
    processOne.addChangeColor(rect1, 0, 0, 0, 11, 11, 11, 16, 20);
    motionTestOne = processOne.getMotions("R1");
    int actual1 = motionTestOne.get(0).getStartTime();
    assertEquals(16, actual1);
    Color color1 = motionTestOne.get(0).getCopyOfShape().getColor();
    Color color2 = new Color(11, 11, 11);
    assertEquals(color1, color2);
    assertEquals(11, motionTestOne.get(0).getEndR());
    assertEquals("CHANGECOLOR", motionTestOne.get(0).getMotion().name());
    processOne.addMove(rect1, 0, 0, 2, 2, 10, 11);
    motionTestOne = processOne.getMotions("R1");
    assertEquals(2, motionTestOne.get(1).getEndY());
  }

  /**
   * Tests changeColor method.
   */
  @org.junit.Test
  public void addChangeColor() {
    assertEquals("R1", rect1.getUniqueCode());
    processOne.addChangeColor(rect1, 0, 0, 0, 11, 11, 11, 16, 20);
    ArrayList<AbstractMotion> motionTestOne;
    motionTestOne = processOne.getMotions("R1");
    int actual1 = motionTestOne.get(0).getStartTime();
    assertEquals(16, actual1);
    Color color1 = motionTestOne.get(0).getCopyOfShape().getColor();
    Color color2 = new Color(11, 11, 11);
    assertEquals(color1, color2);
    assertEquals(11, motionTestOne.get(0).getEndR());
    assertEquals("CHANGECOLOR", motionTestOne.get(0).getMotion().name());
    processOne.addMove(rect1, 0, 0, 2, 2, 10, 11);
    motionTestOne = processOne.getMotions("R1");
    assertEquals(2, motionTestOne.get(1).getEndY());
  }

  /**
   * Tests changePosition method.
   */
  @org.junit.Test
  public void addChangeSize() {
    assertEquals("E1", elli1.getUniqueCode());
    processOne.addMove(elli1, 0, 0, 1, 1, 13, 18);
    ArrayList<AbstractMotion> motionTestOne;
    motionTestOne = processOne.getMotions("E1");
    int actual = motionTestOne.get(0).getStartTime();
    assertEquals(13, actual);

    assertEquals("R1", rect1.getUniqueCode());
    processOne.addChangeColor(rect1, 0, 0, 0, 11, 11, 11, 16, 20);
    motionTestOne = processOne.getMotions("R1");
    int actual1 = motionTestOne.get(0).getStartTime();
    assertEquals(16, actual1);
    Color color1 = motionTestOne.get(0).getCopyOfShape().getColor();
    Color color2 = new Color(11, 11, 11);
    assertEquals(color1, color2);
    assertEquals(11, motionTestOne.get(0).getEndR());
    assertEquals("CHANGECOLOR", motionTestOne.get(0).getMotion().name());

    processOne.addMove(rect1, 0, 0, 2, 2, 10, 11);
    motionTestOne = processOne.getMotions("R1");
    assertEquals(2, motionTestOne.get(1).getEndY());

    processOne.addChangeSize(rect1, 10, 10, 100, 200, 10, 11);
    motionTestOne = processOne.getMotions("R1");
    assertEquals(100, motionTestOne.get(2).getEndWidth());
    assertEquals(200, motionTestOne.get(2).getEndHeight());
    motionTestOne.get(0).getCopyOfShape();
    motionTestOne.get(1).getCopyOfShape();
    assertEquals(2, motionTestOne.get(2).getCopyOfShape().getX());
    assertEquals(11, motionTestOne.get(2).getCopyOfShape().getR());
  }

  /**
   * Tests getState method.
   */
  @org.junit.Test
  public void getState() {
    processOne.addMove(elli1, 0, 0, 10, 10, 13, 18);
    processOne.addChangeColor(rect1, 0, 0, 0, 11, 11, 11, 16, 20);
    processOne.addMove(rect1, 0, 0, 2, 2, 10, 11);
    processOne.addChangeSize(rect1, 10, 10, 100, 200, 10, 11);
    assertEquals(2, processOne.mapOfMotions.size());
    assertEquals(1, processOne.getState(20).size());
    assertEquals(2, processOne.getState(17).size());
    assertEquals(10, processOne.getState(18).get(0).getX());
  }

  /**
   * Tests toString method.
   */
  @org.junit.Test
  public void testToString() {
    processOne.addMove(elli1, 0, 0, 1, 1, 13, 18);
    processOne.addChangeColor(rect1, 0, 0, 0, 11, 11, 11, 16, 20);
    processOne.addMove(rect1, 0, 0, 2, 2, 15, 19);
    processOne.addChangeSize(rect1, 10, 10, 100, 200, 10, 11);
    assertEquals("1", processOne.toString());
  }
}
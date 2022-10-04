package cs5004.animator.model;

import java.awt.Color;

/**
 * The interface represents the shape interface.
 */
public interface ShapeInterface {

  /**
   * Gets the type of the shape.
   * @return the type of the shape
   */
  Shapes getShapeType();

  /**
   * Gets the width of the shape.
   * @return the width of the shape
   */
  int getWidth();

  /**
   * Gets the height of the shape.
   * @return the height of the shape
   */
  int getHeight();

  /**
   * Gets the red value for color.
   * @return the red value for color
   */
  int getR();

  /**
   * Gets the green value for color.
   * @return the green value for color
   */
  int getG();

  /**
   * Gets the blue value for color.
   * @return the blue value for color
   */
  int getB();

  /**
   * Gets the color of the shape.
   * @return the color of the shape
   */
  Color getColor();

  /**
   * Sets the red value.
   * @param r the red value
   */
  void setR(int r);

  /**
   * Sets the green value.
   * @param g the green value
   */
  void setG(int g);

  /**
   * Sets the blue value.
   * @param b the blue value
   */
  void setB(int b);

  /**
   * Sets the color.
   * @param r red value
   * @param g green value
   * @param b blue value
   */
  void setColor(int r, int g, int b);

  /**
   * Gets the x-coordinate of the shape.
   * @return the x-coordinate of the shape
   */
  int getX();

  /**
   * Gets the y-coordinate of the shape.
   * @return the y-coordinate of the shape
   */
  int getY();

  /**
   * Sets the x-coordinate of the shape.
   * @param x the x-coordinate
   */
  void setX(int x);

  /**
   * Sets the y-coordinate of the shape.
   * @param y the y-coordinate
   */
  void setY(int y);

  /**
   * Sets the width of the shape.
   * @param width the width of the shape
   */
  void setWidth(int width);

  /**
   * Sets the height of the shape.
   * @param height the width of the shape
   */
  void setHeight(int height);

  /**
   * Gets the uniqueCode.
   * @return the uniqueCode
   */
  String getUniqueCode();

  /**
   * Sets the uniqueCode.
   * @param uniqueCode the uniqueCode of the shape
   */
  void setUniqueCode(String uniqueCode);

  /**
   * Gets the appearing time of the shape.
   * @return the appearing time of the shape
   */
  int getAppearTime();

  /**
   * Gets the disappearing time of the shape.
   * @return the disappearing time of the shape
   */
  int getDisappearTime();

  /**
   * Sets the appearing time of the shape.
   * @param appearTime time that the shape appear
   */
  void setAppearTime(int appearTime);

  /**
   * Sets the disappearing time of the shape.
   * @param disappearTime time that the shape disappear
   */
  void setDisappearTime(int disappearTime);

  /**
   * Gets the initial flag of whether the shape is declared or not.
   * @return the initial flag of whether the shape is declared or not
   */
  boolean getInitFlag();

  /**
   * Sets the initial flag of whether the shape is declared or not.
   * @param initFlag  the initial flag of whether the shape is declared or not
   */
  void setInitFlag(boolean initFlag);

  /**
   * Makes a copy of the shape.
   * @return a copy of the shape
   */
  ShapeInterface makeACopy();
}

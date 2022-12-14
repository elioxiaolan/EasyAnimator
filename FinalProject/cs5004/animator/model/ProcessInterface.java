package cs5004.animator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This interface represents the process which creates the list used in the animaiton.
 */
public interface ProcessInterface {

  /**
   * Determines whether has the shape or not.
   * @param uniqueCode the only code to determine the shape
   * @return true if has this shape with the uniquecode and false if not
   */
  boolean hasShape(String uniqueCode);

  /**
   * Gets the shapes in the list.
   * @return the list of current shapes in the mapofShape
   */
  List<AbstractShape> getShapes();

  /**
   * Gets one of the certain shape by the uniquecode.
   * @param uniqueCode the only one code for a shape
   * @return the shape if we have the shape in list
   */
  AbstractShape getCertainShape(String uniqueCode);

  /**
   * Gets the shape's all motions.
   * @return the shape's all motions
   */
  ArrayList<AbstractMotion> getMotions(String uniqueCode);

  /**
   * Adds a shape to the hashmap list.
   * @param shape the shape need to put in the list
   */
  void addShape(AbstractShape shape);

  /**
   * Adds a shape to the hashmap list.
   * @param shape         the shape
   * @param x             the x coordinate
   * @param y             the y  coordinate
   * @param width         width of the shape
   * @param height        height of the shape
   * @param r             the red contribute of color
   * @param g             the green
   * @param b             the blue
   * @param uniqueCode    the unique code to determine the shape
   * @param appearTime    appear time
   * @param disappearTime disappear time
   */
  void addShape(Shapes shape, int x, int y, int width, int height,
      int r, int g, int b, String uniqueCode, int appearTime, int disappearTime);

  /**
   * Removes one existed shape.
   * @param uniqueCode the need-remove shape's uniquecode
   */
  void removeShape(String uniqueCode);

  /**
   * Represents the change position motion.
   * @param shape     the shape which needs to change position
   * @param startX    the start x coordinate of the shape
   * @param startY    the start y coordinate of the shape
   * @param endX      the end x coordinate of the shape
   * @param endY      the end y coordinate of the shape
   * @param startTime the start time of the shape
   * @param endTime   the end time of the shape
   */
  void addMove(AbstractShape shape, int startX, int startY, int endX, int endY, int startTime,
      int endTime);

  /**
   * Represents the change color motion.
   * @param shape     the shape which needs to change color
   * @param startR    the start red value of shape
   * @param startG    the start green value of shape
   * @param startB    the start blue value of shape
   * @param endR      the end red value of shape
   * @param endG      the end green value of shape
   * @param endB      the end blue value of shape
   * @param startTime the start time of the shape
   * @param endTime   the end time of the shape
   */
  void addChangeColor(AbstractShape shape, int startR, int startG, int startB, int endR, int endG,
      int endB, int startTime, int endTime);

  /**
   * Represents the change size motion.
   * @param shape       the shape which needs to change size
   * @param starWidth   the start width of shape
   * @param startHeight the start height of shape
   * @param endWidth    the end width of shape
   * @param endHeight   the end height of shape
   * @param startTime   the start time of the shape
   * @param endTime     the end time of the shape
   */
  void addChangeSize(AbstractShape shape, int starWidth, int startHeight, int endWidth,
      int endHeight, int startTime, int endTime);

  /**
   * Gets a list of shapes in a give tick.
   * @param tick the given time
   * @return a list of shapes
   */
  List<AbstractShape> getState(int tick);

  /**
   * The toString method helps execute the textview.
   * @return a string represent the animation
   */
  String toString();

  /**
   * Sets the x coordinate of the canvas.
   * @param x the x coordinate of the canvas
   */
  void setCanvasX(int x);

  /**
   * Sets the y coordinate of the canvas.
   * @param y the y coordinate of the canvas
   */
  void setCanvasY(int y);

  /**
   * Gets the x coordinate of the canvas.
   * @return the x coordinate of the canvas
   */
  int getCanvasX();

  /**
   * Gets the y coordinate of the canvas.
   * @return the y coordinate of the canvas
   */
  int getCanvasY();

  /**
   * Sets the width of the canvas.
   * @param canvasWidth the width of the width
   */
  void setCanvasWidth(int canvasWidth);

  /**
   * Sets the height of the canvas.
   * @param canvasHeight the height of the canvas
   */
  void setCanvasHeight(int canvasHeight);

  /**
   * Gets the width of the canvas.
   * @return the width of the canvas
   */
  int getCanvasWidth();

  /**
   * Gets the height of the canvas.
   * @return the height of the canvas
   */
  int getCanvasHeight();

  /**
   * Gets the end time of the animation.
   * @return the end time of the animation
   */
  int getEndTime();

  /**
   * Sets the end time of the animation.
   * @param endTime the end time of the animation
   */
  void setEndTime(int endTime);

  /**
   * Sets the speed of the animation.
   * @param speed the speed of the animation
   */
  void setSpeed(double speed);

  /**
   * Gets the speed of the animation.
   * @return the speed of the animation
   */
  double getSpeed();

  /**
   * Gets the list of shapes.
   * @return the list of shapes
   */
  HashMap<String, AbstractShape> getMapOfShape();

}

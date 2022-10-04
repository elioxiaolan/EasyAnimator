package cs5004.animator.model;

/**
 * This interface represents the interface of motions.
 */
public interface MotionInterface {

  /**
   * Gets the start time of the motion.
   * @return the start time of the motion
   */
  int getStartTime();

  /**
   * Gets end time of the motion.
   * @return end time of the motion
   */
  int getEndTime();

  /**
   * Sets the start time of the motion.
   * @param startTime the start time of the motion
   */
  void setStartTime(int startTime);

  /**
   * Sets the end time of the motion.
   * @param endTime the end time of the motion
   */
  void setEndTime(int endTime);

  /**
   *Gets the uniquecode of the shape.
   * @return the uniquecode of the shape
   */
  String getUniqueCode();

  /**
   * Sets the uniquecode of the shape.
   * @param uniqueCode the only unique code of the shape
   */
  void setUniqueCode(String uniqueCode);

  /**
   * Gets the start x of the motion.
   * @return the start x of the motion
   */
  int getStartX();

  /**
   * Gets the start y of the motion.
   * @return  the start y of the motion
   */
  int getStartY();

  /**
   * Gets the end x of the motion.
   * @return the end x of the motion
   */
  int getEndX();

  /**
   * Gets the end y of the motion.
   * @return the end y of the motion
   */
  int getEndY();

  /**
   * Sets the start x of the motion.
   * @param x the x of the motion
   */
  void setStartX(int x);

  /**
   * Sets the start y of the motion.
   * @param y the start y of the motion
   */
  void setStartY(int y);

  /**
   * Sets the end x of the motion.
   * @param x the end x of the motion
   */
  void setEndX(int x);

  /**
   * Sets the end y of the motion.
   * @param y the end x of the motion
   */
  void setEndY(int y);

  /**
   * Gets the start width of the motion.
   * @return the start width of the motion
   */
  int getStartWidth();

  /**
   * Gets the start height of the motion.
   * @return the start height of the motion
   */
  int getStartHeight();

  /**
   * Gets the end width of the motion.
   * @return the end width of the motion
   */
  int getEndWidth();

  /**
   * Gets the end height of the motion.
   * @return the end height of the motion
   */
  int getEndHeight();

  /**
   * Sets the start width of the motion.
   * @param startWidth the start width of the motion
   */
  void setStartWidth(int startWidth);

  /**
   * Sets the start height of the motion.
   * @param startHeight the start height of the motion
   */
  void setStartHeight(int startHeight);

  /**
   * Sets the end width of the motion.
   * @param endWidth  the end width of the motion
   */
  void setEndWidth(int endWidth);

  /**
   * Sets the end height of the motion.
   * @param endHeight the end height of the motion
   */
  void setEndHeight(int endHeight);

  /**
   * Gets the start red value of the motion.
   * @return the start red value of the motion
   */
  int getStartR();

  /**
   * Gets the start greeen value of the motion.
   * @return the start green value of the motion
   */
  int getStartG();

  /**
   * Gets the start blue value of the motion.
   * @return the start blue value of the motion
   */
  int getStartB();

  /**
   * Gets the end red value of the motion.
   * @return the end red value of the motion
   */
  int getEndR();

  /**
   * Gets the end green value of the motion.
   * @return the green value of the motion
   */
  int getEndG();

  /**
   * Gets the end blue value of the motion.
   * @return the blue red value of the motion
   */
  int getEndB();

  /**
   * Sets the red value of the motion.
   * @param r the red value of the motion
   */
  void setStartR(int r);

  /**
   * Sets the green value of the motion.
   * @param g the green value of the motion
   */
  void setStartG(int g);

  /**
   * Sets the blue value of the motion.
   * @param b the blue value of the motion
   */
  void setStartB(int b);

  /**
   * Sets the end red value of the motion.
   * @param r the end red value of the motion
   */
  void setEndR(int r);

  /**
   * Sets the end green value of the motion.
   * @param g the end green value of the motion
   */
  void setEndG(int g);

  /**
   * Sets the end blue value of the motion.
   * @param b the end blue value of the motion
   */
  void setEndB(int b);

  /**
   * Gets the shape type of the shape.
   * @return the shape type of the shape
   */
  Shapes getShapeType();

  /**
   * Sets the type of the shape.
   * @param shapeType  the type of the shape
   */
  void setShapeType(Shapes shapeType);

  /**
   * Gets the motion.
   * @return the motion
   */
  Motions getMotion();

  /**
   * Sets the motion.
   * @param motion the motion
   */
  void setMotion(Motions motion);

  /**
   * Gets the string of the motion.
   * @return the string of the motion
   */
  String toString();

  /**
   * Sets the copy of the shape.
   * @param shape the shape
   */
  void setCopyOfShape(AbstractShape shape);

  /**
   * Gets the copy of the shape.
   * @return the copy of the shape
   */
  AbstractShape getCopyOfShape();
}

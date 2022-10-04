package cs5004.animator.model;

/**
 * This enum represents different kinds of shapes.
 */
public enum Shapes {
  RECTANGLE, ELLIPSE;
  /**
   * The toString method represents the string of the shapes.
   * @return the string of the shapes.
   */
  public String toString() {
    return this.name();
  }
}

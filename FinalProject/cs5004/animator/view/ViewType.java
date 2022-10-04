package cs5004.animator.view;

/**
 * This enum represents different kinds of view type.
 */
public enum ViewType {
  TEXTVIEW,VISUALVIEW,SVGVIEW;

  /**
   * Get the string of view type.
   * @return the string of view type.
   */
  public String toString() {
    return this.name();
  }
}

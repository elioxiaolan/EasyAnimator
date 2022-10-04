package cs5004.animator.model;

/**
 * This enum represents different kinds of motions.
 */
public enum Motions {
  CHANGEPOSITION,CHANGECOLOR, CHANGESIZE;

  /**
   * The toString method represents the string of the motions.
   * @return the string of the motions.
   */
  public String toString() {
    return this.name();
  }
}

package cs5004.animator.model;


/**
 * This class represents the change of size of the motion.
 */
public class ChangeSize extends AbstractMotion {

  private int startWidth;
  private int startHeight;
  private int endWidth;
  private int endHeight;

  /**
   * The constructor of the Change Size.
   *
   * @param shape       the shape that change size
   * @param uniqueCode  the only unique code for the shape
   * @param startWidth  the start width of the shape
   * @param startHeight the start height of the shape
   * @param endWidth    the end width of the shape
   * @param endHeight   the end height of the shape
   * @param startTime   the start time of the motion
   * @param endTime     the end time of the motion
   */
  public ChangeSize(AbstractShape shape, String uniqueCode, int startWidth, int startHeight,
      int endWidth, int endHeight, int startTime, int endTime) {
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setUniqueCode(uniqueCode);
    super.setShapeType(shape.getShapeType());
    super.setMotion(Motions.CHANGESIZE);
    super.setCopyOfShape(shape);
    this.setStartWidth(startWidth);
    this.setStartHeight(startHeight);
    this.setEndWidth(endWidth);
    this.setEndHeight(endHeight);

  }

  @Override
  public int getStartX() {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public int getStartY() {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public int getEndX() {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public int getEndY() {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public void setStartX(int x) {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public void setStartY(int y) {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public void setEndX(int x) {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public void setEndY(int y) {
    throw new IllegalArgumentException("Cannot change position in Changesize.");
  }

  @Override
  public int getStartWidth() {
    return this.startWidth;
  }

  @Override
  public int getStartHeight() {
    return this.startHeight;
  }

  @Override
  public int getEndWidth() {
    return this.endWidth;
  }

  @Override
  public int getEndHeight() {
    return this.endHeight;
  }

  @Override
  public void setStartWidth(int startWidth) {
    this.startWidth = startWidth;
  }

  @Override
  public void setStartHeight(int startHeight) {
    this.startHeight = startHeight;
  }

  @Override
  public void setEndWidth(int endWidth) {
    this.endWidth = endWidth;
  }

  @Override
  public void setEndHeight(int endHeight) {
    this.endHeight = endHeight;
  }

  @Override
  public int getStartR() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public int getStartG() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public int getStartB() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public int getEndR() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public int getEndG() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public int getEndB() {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public void setStartR(int r) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public void setStartG(int g) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public void setStartB(int b) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public void setEndR(int r) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public void setEndG(int g) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public void setEndB(int b) {
    throw new IllegalArgumentException("Cannot change color in Changesize.");
  }

  @Override
  public void setCopyOfShape(AbstractShape shape) {
    this.currentShape.setWidth(endWidth);
    this.currentShape.setHeight(endHeight);
  }

  @Override
  public AbstractShape getCopyOfShape() {
    this.currentShape.setWidth(endWidth);
    this.currentShape.setHeight(endHeight);
    return this.currentShape;
  }

  @Override
  public String toString() {
    String changeSizeString;
    if (this.getStartHeight() == this.getEndHeight()) {
      changeSizeString =
          this.getUniqueCode() + " changes width from " + this.getStartWidth() + " to "
              + this.getEndWidth() + " from time t =" + this.getStartTime() + " to "
              + this.getEndTime() + ".\n";
      return changeSizeString;
    } else if (this.getEndWidth() == this.getStartWidth()) {
      changeSizeString =
          this.getUniqueCode() + " changes height from " + this.getStartHeight() + " to "
              + this.getEndHeight() + "  time t=" + this.getStartTime() + " to "
              + this.getEndTime() + ".\n";
      return changeSizeString;
    } else {
      changeSizeString =
          this.getUniqueCode() + " changes width from " + this.getStartWidth() + " to "
              + this.getEndWidth() + " and changes height from" + this.getStartHeight() + " to "
              + this.getEndHeight() + " from time t=" + this.getStartTime() + " to "
              + this.getEndTime() + ".\n";
      return changeSizeString;
    }
  }
}

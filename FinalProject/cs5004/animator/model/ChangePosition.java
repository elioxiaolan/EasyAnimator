package cs5004.animator.model;

/**
 * This class represent the change of position of the motion.
 */
public class ChangePosition extends AbstractMotion {

  private int startX;
  private int startY;
  private int endX;
  private int endY;

  /**
   * This constructor of Change Position.
   *
   * @param shape      the shape that change position
   * @param uniqueCode the only unique code of the shape
   * @param startX     the start x coordinate of the shape
   * @param startY     the start y coordinate of the shape
   * @param endX       the end  x coordinate of the shape
   * @param endY       the end  y coordinate of the shape
   * @param startTime  the start time of the motion
   * @param endTime    the end time of the motion
   */
  public ChangePosition(AbstractShape shape, String uniqueCode, int startX, int startY, int endX,
      int endY, int startTime, int endTime) {
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeType(shape.getShapeType());
    super.setMotion(Motions.CHANGEPOSITION);
    super.setUniqueCode(uniqueCode);
    super.setCopyOfShape(shape);
    this.setStartX(startX);
    this.setStartY(startY);
    this.setEndX(endX);
    this.setEndY(endY);
  }

  @Override
  public int getStartX() {
    return this.startX;
  }

  @Override
  public int getStartY() {
    return this.startY;
  }

  @Override
  public int getEndX() {
    return this.endX;
  }

  @Override
  public int getEndY() {
    return this.endY;
  }

  @Override
  public void setStartX(int x) {
    this.startX = x;
  }

  @Override
  public void setStartY(int y) {
    this.startY = y;
  }

  @Override
  public void setEndX(int x) {
    this.endX = x;
  }

  @Override
  public void setEndY(int y) {
    this.endY = y;

  }

  @Override
  public int getStartWidth() {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  @Override
  public int getStartHeight() {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  @Override
  public int getEndWidth() {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  @Override
  public int getEndHeight() {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  @Override
  public void setStartWidth(int startWidth) {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  @Override
  public void setStartHeight(int startHeight) {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  @Override
  public void setEndWidth(int endWidth) {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  @Override
  public void setEndHeight(int endHeight) {
    throw new IllegalArgumentException("Cannot change size in this motion.");
  }

  @Override
  public int getStartR() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public int getStartG() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public int getStartB() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public int getEndR() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public int getEndG() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public int getEndB() {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public void setStartR(int r) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public void setStartG(int g) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public void setStartB(int b) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public void setEndR(int r) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public void setEndG(int g) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public void setEndB(int b) {
    throw new IllegalArgumentException("Cannot change color in this motion.");
  }

  @Override
  public void setCopyOfShape(AbstractShape shape) {
    this.currentShape.setX(this.endX);
    this.currentShape.setY(this.endY);
  }

  @Override
  public AbstractShape getCopyOfShape() {
    this.currentShape.setX(this.endX);
    this.currentShape.setY(this.endY);
    return this.currentShape;
  }

  @Override
  public String toString() {
    String changePositionString;
    changePositionString =
        this.getUniqueCode() + " moves from " + "(" + this.getStartX() + "," + this.getStartY()
            + ") to ( " + this.getEndX() + "," + this.getEndY() + ") from time t= "
            + this.getStartTime() + " to time t= " + this.getEndTime() + ".\n";
    return changePositionString;
  }
}

package cs5004.animator.model;

/**
 * This class represents the motion which implements the motion interface.
 */
public abstract class AbstractMotion implements MotionInterface {

  private int startTime;
  private int endTime;
  private String uniqueCode;
  private Motions motion;
  private Shapes shapeType;
  protected AbstractShape currentShape;

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  @Override
  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  @Override
  public String getUniqueCode() {
    return this.uniqueCode;
  }

  @Override
  public void setUniqueCode(String uniqueCode) {
    this.uniqueCode = uniqueCode;
  }

  @Override
  public Shapes getShapeType() {
    return this.shapeType;
  }

  @Override
  public void setShapeType(Shapes shapeType) {
    this.shapeType = shapeType;
  }

  @Override
  public Motions getMotion() {
    return this.motion;
  }

  @Override
  public void setMotion(Motions motion) {
    this.motion = motion;
  }

  @Override
  public void setCopyOfShape(AbstractShape shape) {
    this.currentShape = shape;
  }

  @Override
  public AbstractShape getCopyOfShape() {
    return this.currentShape;
  }
}

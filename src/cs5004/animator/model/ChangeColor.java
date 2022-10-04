package cs5004.animator.model;

import java.awt.Color;

/**
 * Ths class represents the change process of color of motion.
 */
public class ChangeColor extends AbstractMotion {

  private int startR;
  private int startG;
  private int startB;
  private int endR;
  private int endG;
  private int endB;


  /**
   * The constructor of the ChangeColor motion.
   * @param shape      the shape which  changes color
   * @param uniqueCode the unique code of the shape
   * @param startR     the start red value of the shape
   * @param startG     the start green value of the shape
   * @param startB     the start blue value of the shape
   * @param endR       the end red value of the shape
   * @param endG       the end green value of the shape
   * @param endB       the end blue value of the shape
   * @param startTime  the start time of the motion
   * @param endTime    the end time of the motion
   */
  public ChangeColor(AbstractShape shape, String uniqueCode, int startR, int startG, int startB,
      int endR, int endG, int endB,
      int startTime, int endTime) {
    super.setStartTime(startTime);
    super.setEndTime(endTime);
    super.setShapeType(shape.getShapeType());
    super.setUniqueCode(uniqueCode);
    super.setMotion(Motions.CHANGECOLOR);
    super.setCopyOfShape(shape);
    this.setStartR(startR);
    this.setStartG(startG);
    this.setStartB(startB);
    this.setEndR(endR);
    this.setEndG(endG);
    this.setEndB(endB);
  }

  @Override
  public int getStartX() {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  @Override
  public int getStartY() {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  @Override
  public int getEndX() {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  @Override
  public int getEndY() {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  @Override
  public void setStartX(int x) {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  @Override
  public void setStartY(int y) {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  @Override
  public void setEndX(int x) {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  @Override
  public void setEndY(int y) {
    throw new IllegalArgumentException("Cannot change position in Changecolor.");
  }

  @Override
  public int getStartWidth() {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  @Override
  public int getStartHeight() {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  @Override
  public int getEndWidth() {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  @Override
  public int getEndHeight() {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  @Override
  public void setStartWidth(int startWidth) {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  @Override
  public void setStartHeight(int startHeight) {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  @Override
  public void setEndWidth(int endWidth) {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  @Override
  public void setEndHeight(int endHeight) {
    throw new IllegalArgumentException("Cannot change size in Changecolor.");
  }

  @Override
  public int getStartR() {
    return this.startR;
  }

  @Override
  public int getStartG() {
    return this.startG;
  }

  @Override
  public int getStartB() {
    return this.startB;
  }

  @Override
  public int getEndR() {
    return this.endR;
  }

  @Override
  public int getEndG() {
    return this.endG;
  }

  @Override
  public int getEndB() {
    return this.endB;
  }

  @Override
  public void setStartR(int r) {
    this.startR = r;
  }

  @Override
  public void setStartG(int g) {
    this.startG = g;
  }

  @Override
  public void setStartB(int b) {
    this.startB = b;
  }

  @Override
  public void setEndR(int r) {
    this.endR = r;
  }

  @Override
  public void setEndG(int g) {
    this.endG = g;
  }

  @Override
  public void setEndB(int b) {
    this.endB = b;
  }

  public Color getStartColor() {
    return new Color(startR, startG, startB);
  }

  public Color getEndColor() {
    return new Color(endR, endG, endB);
  }

  @Override
  public void setCopyOfShape(AbstractShape shape) {
    this.currentShape.setColor(this.endR, this.endG, this.endB);

  }

  @Override
  public AbstractShape getCopyOfShape() {
    this.currentShape.setR(this.endR);
    this.currentShape.setG(this.endG);
    this.currentShape.setB(this.endB);
    this.currentShape.setColor(this.endR, this.endG, this.endB);
    return this.currentShape;
  }

  @Override
  public String toString() {
    String changeColorString;
    changeColorString =
        this.getUniqueCode() + " changes from color(Red: " + this.getStartR() + " Green: "
            + this.getStartG() + " Blue:" + this.getStartB() + ") to color(Red: " + this.getEndR()
            + " Green: "
            + this.getEndG() + " Blue:" + this.getEndB() + " from time t= " + this.getStartTime()
            + " to "
            + this.getEndTime() + ".\n";
    return changeColorString;
  }

}

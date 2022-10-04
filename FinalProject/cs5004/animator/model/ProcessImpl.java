package cs5004.animator.model;

import cs5004.animator.util.AnimationBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * The class represents the implementation of Process interface.
 */
public class ProcessImpl implements ProcessInterface {

  protected final LinkedHashMap<String, AbstractShape> mapOfShape;
  protected final LinkedHashMap<String, List<AbstractMotion>> mapOfMotions;
  private int canvasWidth;
  private int canvasHeight;
  private int canvasX;
  private int canvasY;
  private int endTime;
  private double speed;

  /**
   * The constructor of ProcessImpl.
   */
  public ProcessImpl() {
    this.mapOfShape = new LinkedHashMap<>();
    this.mapOfMotions = new LinkedHashMap<>();
  }

  @Override
  public boolean hasShape(String uniqueCode) {
    return this.mapOfShape.containsKey(uniqueCode);
  }

  @Override
  public List<AbstractShape> getShapes() {

    List<AbstractShape> shapes = new ArrayList<>(mapOfShape.values());
    return shapes;
  }

  @Override
  public HashMap<String, AbstractShape> getMapOfShape() {
    return this.mapOfShape;
  }

  @Override
  public AbstractShape getCertainShape(String uniqueCode) {
    if (!hasShape(uniqueCode)) {
      throw new IllegalArgumentException("Don't have such shape.");
    }
    return this.mapOfShape.get(uniqueCode);
  }

  @Override
  public ArrayList<AbstractMotion> getMotions(String uniqueCode) {
    ArrayList<AbstractMotion> motions = new ArrayList<AbstractMotion>(
        mapOfMotions.get(uniqueCode));
    return motions;
  }

  @Override
  public void addShape(AbstractShape shape) throws IllegalArgumentException {

    if (mapOfShape.containsKey(shape.getUniqueCode())) {
      throw new IllegalArgumentException("The shape with this uniquecode has already exist.");
    } else if (!mapOfShape.containsKey(shape.getUniqueCode())) {
      if (shape.getShapeType().equals(Shapes.ELLIPSE) || shape.getShapeType()
          .equals(Shapes.RECTANGLE)) {
        this.mapOfShape.put(shape.getUniqueCode(), shape);
        this.mapOfMotions.put(shape.getUniqueCode(), new ArrayList<>());
      } else {
        throw new IllegalArgumentException("Need to add a new shape type in the enum.");
      }
    }
  }

  @Override
  public void addShape(Shapes shape, int x, int y, int width, int height,
      int r, int g, int b, String uniqueCode, int appearTime, int disappearTime) {
    if (width < 0 || height < 0 || r < 0 || g < 0 || b < 0 || r > 255 || g > 255 || b > 255
        || appearTime < 0 || disappearTime < 0 || disappearTime < appearTime) {
      throw new IllegalArgumentException(
          "Can not creat a shape because the value is wrong.Check it");
    }
    if (mapOfShape.containsKey(uniqueCode)) {
      throw new IllegalArgumentException("The shape with this uniquecode has already exist.");
    }
    if (shape.equals(Shapes.ELLIPSE)) {
      AbstractShape shapeNew = new Ellipse(x, y, width, height, r, g, b, uniqueCode, appearTime,
          disappearTime);
      mapOfShape.put(uniqueCode, shapeNew);
      this.mapOfMotions.put(uniqueCode, new ArrayList<>());
    } else if (shape.equals(Shapes.RECTANGLE)) {
      AbstractShape shapeNew = new Rectangle(x, y, width, height, r, g, b, uniqueCode, appearTime,
          disappearTime);
      mapOfShape.put(uniqueCode, shapeNew);
      this.mapOfMotions.put(uniqueCode, new ArrayList<>());
    } else {
      throw new IllegalArgumentException("Need to add a new shape type in the enum.");
    }
  }

  @Override
  public void removeShape(String uniqueCode) {
    if (mapOfShape.containsKey(uniqueCode)) {
      mapOfShape.remove(uniqueCode);
    } else {
      throw new IllegalArgumentException("shape doesn't exist.");
    }
  }

  /**
   * A helper method to determine whether motion is confilct.
   * @param shape     the shape
   * @param motion    the motion
   * @param timeStart start time
   * @param timeEnd   end time
   * @return true if time not conflict and false if confilct
   */
  private boolean confilctingOneTime(AbstractShape shape, Motions motion, int timeStart,
      int timeEnd) {
    for (List<AbstractMotion> motionsList : this.mapOfMotions.values()) {
      for (AbstractMotion m : motionsList) {
        if (Objects.equals(shape.getUniqueCode(), m.getUniqueCode())) {
          if (motion == m.getMotion()) {
            if ((m.getStartTime() < timeStart && m.getEndTime() > timeEnd) || (
                m.getStartTime() > timeStart && m.getEndTime() < timeEnd) || (
                m.getStartTime() < timeStart && m.getEndTime() > timeStart) || (
                m.getStartTime() < timeEnd && m.getEndTime() > timeEnd)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  @Override
  public void addMove(AbstractShape shape, int startX, int startY, int endX, int endY,
      int startTime,
      int endTime) {
    if (startTime > endTime || startTime < 0) {
      throw new IllegalArgumentException("time input is wrong.");
    }
    if (confilctingOneTime(shape, Motions.CHANGEPOSITION, startTime, endTime)) {
      throw new IllegalArgumentException("the shape can only have one motion in certain time.");
    }

    if (!mapOfShape.containsKey(shape.getUniqueCode())) {
      this.addShape(shape);
    }
    String key = shape.getUniqueCode();
    mapOfMotions.get(key)
        .add(new ChangePosition(shape, shape.getUniqueCode(), startX, startY, endX, endY,
            startTime, endTime));
  }

  @Override
  public void addChangeColor(AbstractShape shape, int startR, int startG, int startB, int endR,
      int endG, int endB, int startTime, int endTime) {
    if (startTime < 0 || endTime < 0 || startTime > endTime) {
      throw new IllegalArgumentException("time input is wrong.");
    }
    if (confilctingOneTime(shape, Motions.CHANGECOLOR, startTime, endTime)) {
      throw new IllegalArgumentException("the shape can only have one motion in certain time.");
    }

    if (!mapOfShape.containsKey(shape.getUniqueCode())) {
      this.addShape(shape);
    }
    String key = shape.getUniqueCode();
    mapOfMotions.get(key)
        .add(new ChangeColor(shape, shape.getUniqueCode(), startR, startG, startB, endR,
            endG, endB, startTime, endTime));
  }

  @Override
  public void addChangeSize(AbstractShape shape, int starWidth, int startHeight, int endWidth,
      int endHeight, int startTime, int endTime) {
    if (startTime < 0 || endTime < 0 || startTime > endTime) {
      throw new IllegalArgumentException("time input is wrong.");
    }
    if (confilctingOneTime(shape, Motions.CHANGESIZE, startTime, endTime)) {
      throw new IllegalArgumentException("the shape can only have one motion in certain time.");
    }

    if (!mapOfShape.containsKey(shape.getUniqueCode())) {
      this.addShape(shape);
    }
    String key = shape.getUniqueCode();
    mapOfMotions.get(key).add(new ChangeSize(shape, shape.getUniqueCode(), starWidth, startHeight,
        endWidth, endHeight, startTime, endTime));

  }

  @Override
  public List<AbstractShape> getState(int tick) {
    if (tick < 0) {
      throw new IllegalArgumentException("tick shouldn't be negative int.");
    }
    List<AbstractShape> processCopy = new ArrayList<>();
    for (List<AbstractMotion> motionList : mapOfMotions.values()) {
      for (AbstractMotion motion : motionList) {
        if (motion.getStartTime() <= tick && motion.getEndTime() >= tick) {
          float startTime = motion.getStartTime();
          float endTime = motion.getEndTime();
          float tweening = 0;
          if (endTime == startTime) {
            tweening = 1;
          } else {
            tweening = (tick - startTime) / (endTime - startTime);
          }
          switch (motion.getMotion()) {
            case CHANGEPOSITION: {
              int startX = motion.getStartX();
              int startY = motion.getStartY();
              int endX = motion.getEndX();
              int endY = motion.getEndY();
              float tickX = (startX * (1 - tweening) + endX * tweening);
              float tickY = (startY * (1 - tweening) + endY * tweening);
              int newX = Math.round(tickX);
              int newY = Math.round(tickY);
              AbstractShape shape = motion.getCopyOfShape();
              shape.setX(newX);
              shape.setY(newY);
              processCopy.add(shape);
              break;
            }
            case CHANGECOLOR: {
              int startR = motion.getStartR();
              int startG = motion.getStartG();
              int startB = motion.getStartB();
              int endR = motion.getEndR();
              int endG = motion.getEndG();
              int endB = motion.getEndB();
              float tickR = (startR * (1 - tweening) + endR * tweening);
              float tickG = (startG * (1 - tweening) + endG * tweening);
              float tickB = (startB * (1 - tweening) + endB * tweening);
              int newR = Math.round(tickR);
              int newG = Math.round(tickG);
              int newB = Math.round(tickB);
              AbstractShape shape = motion.getCopyOfShape();
              shape.setR(newR);
              shape.setG(newG);
              shape.setB(newB);
              shape.setColor(newR, newG, newB);
              processCopy.add(shape);
              break;

            }
            case CHANGESIZE: {
              int startWidth = motion.getStartWidth();
              int startHeight = motion.getStartHeight();
              int endWidth = motion.getEndWidth();
              int endHeight = motion.getEndHeight();
              float tickWidth = startWidth * (1 - tweening) + endWidth * tweening;
              float tickHeight = startHeight * (1 - tweening) + endHeight * tweening;
              int newWidth = Math.round(tickWidth);
              int newHeight = Math.round(tickHeight);
              AbstractShape shape = motion.getCopyOfShape();
              shape.setWidth(newWidth);
              shape.setHeight(newHeight);
              processCopy.add(shape);
              break;
            }
            default: {
              throw new IllegalArgumentException("Should not have such exception.");
            }
          }
        }
      }
    }
    return processCopy;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (AbstractShape shape : mapOfShape.values()) {
      stringBuilder.append(
          "Create " + shape.getShapeType().toString() + " "
              + shape.getUniqueCode() + " with color ( Red: " + shape.getR() + " Green: "
              + shape.getG() + " Blue:" + shape.getB() + " ) and with ");
      String positiontype = "";
      String positionOriginal = "";
      String widthAndHeight = "";
      positionOriginal = "(" + shape.getX() + "," + shape.getY() + "),";
      if (shape.getShapeType() == Shapes.RECTANGLE) {
        positiontype = " corner ";
        widthAndHeight = " width " + shape.getWidth() + " and height " + shape.getHeight();


      }
      if (shape.getShapeType() == Shapes.ELLIPSE) {
        positiontype = " center ";
        widthAndHeight = " radius " + shape.getWidth() + " and  " + shape.getHeight();
      }
      stringBuilder.append(positiontype);
      stringBuilder.append(positionOriginal);
      stringBuilder.append(widthAndHeight);
      stringBuilder.append(".\n");
    }
    stringBuilder.append("\n");
    for (AbstractShape shape : mapOfShape.values()) {
      stringBuilder.append(shape.getUniqueCode());
      stringBuilder.append(" appears at time t = ");
      stringBuilder.append(shape.getAppearTime());
      stringBuilder.append(" and disappear at time t = ");
      stringBuilder.append(shape.getDisappearTime());
      stringBuilder.append(".\n");
    }
    stringBuilder.append("\n");
    List<ArrayList<String>> list = new ArrayList<>();
    int number = 0;
    for (String shapeInList : this.mapOfShape.keySet()) {
      for (AbstractMotion motionInTheShapeList : this.mapOfMotions.get(shapeInList)) {
        list.add(new ArrayList<>());
        list.get(number).add(Double.toString(motionInTheShapeList.getStartTime()));
        list.get(number).add(motionInTheShapeList.toString());
        number++;
      }
    }
    list.sort(Comparator.comparingDouble(o -> Double.parseDouble(o.get(0))));
    for (ArrayList<String> listOutput : list) {
      stringBuilder.append(listOutput.get(1));
    }
    return stringBuilder.toString();
  }

  @Override
  public void setCanvasX(int x) {
    this.canvasX = x;
  }

  @Override
  public void setCanvasY(int y) {
    this.canvasY = y;
  }

  @Override
  public int getCanvasX() {
    return this.canvasX;
  }

  @Override
  public int getCanvasY() {
    return this.canvasY;
  }

  @Override
  public void setCanvasWidth(int canvasWidth) {
    this.canvasWidth = canvasWidth;
  }

  @Override
  public void setCanvasHeight(int canvasHeight) {
    this.canvasHeight = canvasHeight;
  }

  @Override
  public int getCanvasWidth() {
    return this.canvasWidth;
  }

  @Override
  public int getCanvasHeight() {
    return this.canvasHeight;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  @Override
  public void setSpeed(double speed) {
    this.speed = speed;
  }

  @Override
  public double getSpeed() {
    return this.speed;
  }

  /**
   * It is a class of builder of the animation using the processImpl.
   */
  public static final class OneBuilder implements AnimationBuilder<ProcessInterface> {

    private ProcessInterface model;

    /**
     * Constructor of the builder.
     *
     * @param model the model we pass to the builder.
     */
    public OneBuilder(ProcessInterface model) {
      this.model = model;
    }

    /**
     * Constructs a final document.
     *
     * @return the newly constructed document
     */
    @Override
    public ProcessInterface build() {
      return this.model;
    }

    /**
     * Specify the bounding box to be used for the animation.
     *
     * @param x      The leftmost x value
     * @param y      The topmost y value
     * @param width  The width of the bounding box
     * @param height The height of the bounding box
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<ProcessInterface> setBounds(int x, int y, int width, int height) {
      this.model.setCanvasX(x);
      this.model.setCanvasY(y);
      this.model.setCanvasWidth(width);
      this.model.setCanvasHeight(height);
      return this;
    }

    /**
     * Adds a new shape to the growing document.
     *
     * @param name The unique name of the shape to be added. No shape with this name should already
     *             exist.
     * @param type The type of shape (e.g. "ellipse", "rectangle") to be added. The set of supported
     *             shapes is unspecified, but should include "ellipse" and "rectangle" as a
     *             minimum.
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<ProcessInterface> declareShape(String name, String type) {
      if (type.equalsIgnoreCase("rectangle")) {
        this.model.addShape(new Rectangle(name));
      } else if (type.equalsIgnoreCase("ellipse")) {
        this.model.addShape(new Ellipse(name));
      } else {
        throw new IllegalArgumentException("Must be rectangle or ellipse");
      }
      return this;
    }

    /**
     * Adds a transformation to the growing document.
     * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
     * @param t1   The start time of this transformation
     * @param x1   The initial x-position of the shape
     * @param y1   The initial y-position of the shape
     * @param w1   The initial width of the shape
     * @param h1   The initial height of the shape
     * @param r1   The initial red color-value of the shape
     * @param g1   The initial green color-value of the shape
     * @param b1   The initial blue color-value of the shape
     * @param t2   The end time of this transformation
     * @param x2   The final x-position of the shape
     * @param y2   The final y-position of the shape
     * @param w2   The final width of the shape
     * @param h2   The final height of the shape
     * @param r2   The final red color-value of the shape
     * @param g2   The final green color-value of the shape
     * @param b2   The final blue color-value of the shape
     * @return This {@link AnimationBuilder}
     */
    @Override
    public AnimationBuilder<ProcessInterface> addMotion(String name, int t1, int x1, int y1, int w1,
        int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
        int b2) {
      if (t2 > model.getEndTime()) {
        model.setEndTime(t2);
      }
      AbstractShape currentShape = this.model.getMapOfShape().get(name);
      if (!currentShape.getInitFlag() || currentShape.getAppearTime() > t1) {
        currentShape.setX(x1);
        currentShape.setY(y1);
        currentShape.setWidth(w1);
        currentShape.setHeight(h1);
        currentShape.setR(r1);
        currentShape.setG(g1);
        currentShape.setB(b1);
        currentShape.setColor(r1, g1, b1);
        currentShape.setAppearTime(t1);
        currentShape.setDisappearTime(t2);
        currentShape.setInitFlag(true);
      }
      if (currentShape.getDisappearTime() < t2) {
        currentShape.setDisappearTime(t2);
      }
      if (x2 - x1 != 0 || y2 - y1 != 0) {
        model.addMove(model.getCertainShape(name), x1, y1, x2, y2, t1, t2);
      }
      if (w2 - w1 != 0 || h2 - h1 != 0) {
        model.addChangeSize(model.getCertainShape(name), w1, h1, w2, h2, t1, t2);
      }
      if (r2 - r1 != 0 || g2 - g1 != 0 || b2 - b1 != 0) {
        model.addChangeColor(model.getCertainShape(name), r1, g1, b1, r2, g2, b2, t1, t2);
      }
      if (t1 - t2 != 0 && (x1 == x2 && y1 == y2 && w1 == w2 && h1 == h2 && r1 == r2 && g1 == g2
          && b1 == b2)) {
        this.model.addMove(model.getCertainShape(name), x1, y1, x2, y2, t1, t2);
      }
      if (t1 == t2) {
        this.model.addMove(model.getCertainShape(name), x1, y1, x2, y2, t1, t2);
      }
      return this;
    }
  }
}
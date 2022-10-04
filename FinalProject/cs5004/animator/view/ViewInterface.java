package cs5004.animator.view;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.ProcessInterface;

import java.util.List;

/**
 * This interface represents a view.
 */
public interface ViewInterface {

  /**
   * Gets the string of the shape type.
   * @return the string of the shape type
   */
  String typeOfView();

  /**
   * Gets the view in string,not for visual view.
   * @return the view in string
   */
  String viewInString();

  /**
   * Gets the current tick shapes.Used in visual view.
   * @param shapeList he current tick shapes
   */
  void getCurrentView(List<AbstractShape> shapeList);

  /**
   * Gets the model.
   * @return the model
   */
  ProcessInterface getModel();

  /**
   * Gets the output file.
   * @return the output file
   */
  String getOutputFile();
}

package cs5004.animator.view;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.ProcessInterface;

import java.util.List;

/**
 * This class represents a textview .
 */
public class TextView implements ViewInterface {

  ProcessInterface processModel;

  /**
   * The constructor of the textview.
   * @param processModel the model used in the view
   */
  public TextView(ProcessInterface processModel) {
    if (processModel == null) {
      throw new IllegalArgumentException("Input is null.");
    }
    this.processModel = processModel;
  }

  @Override
  public String viewInString() {
    return this.processModel.toString();
  }

  @Override
  public void getCurrentView(List<AbstractShape> shapeList) {
    throw new IllegalArgumentException("Textview does not support get current view");
  }

  @Override
  public ProcessInterface getModel() {
    return this.processModel;
  }

  @Override
  public String getOutputFile() {
    throw new IllegalArgumentException("Outputfile is not supported in textview.");
  }

  @Override
  public String typeOfView() {
    return ViewType.TEXTVIEW.name();
  }
}

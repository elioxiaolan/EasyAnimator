package cs5004.animator.view;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.ProcessInterface;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollBar;

/**
 * This class represents a visual view.
 */
public class VisualView extends JFrame implements ViewInterface {

  private ProcessInterface model;

  private VisuaViewPanel visuaViewPanel;

  /**
   * The constructor of visual view.
   * @param model the model
   *
   */
  public VisualView(ProcessInterface model) {
    super();
    int frameX = model.getCanvasX();
    int frameY = model.getCanvasY();
    int frameWidth = model.getCanvasWidth();
    int frameHeight = model.getCanvasHeight();
    this.model = model;
    this.setTitle("Easy Animator");
    this.setBounds(frameX, frameY, frameWidth, frameHeight);
    this.getPreferredSize();
    this.visuaViewPanel = new VisuaViewPanel(model.getShapes());
    this.visuaViewPanel.setVisible(true);
    this.add(this.visuaViewPanel, BorderLayout.CENTER);

    class VerticalListener implements AdjustmentListener {

      @Override
      public void adjustmentValueChanged(AdjustmentEvent e) {
        setPanelX(e.getValue());
      }

    }

    class HorizonListener implements AdjustmentListener {

      @Override
      public void adjustmentValueChanged(AdjustmentEvent e) {
        setPanelY(e.getValue());
      }
    }

    JScrollBar verticalScorllBar = new JScrollBar(JScrollBar.VERTICAL, 0, 30, -100, 100);
    JScrollBar horizonScorllBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 30, -100, 100);
    verticalScorllBar.addAdjustmentListener(new HorizonListener());
    horizonScorllBar.addAdjustmentListener(new VerticalListener());
    this.getContentPane().add(verticalScorllBar, BorderLayout.WEST);
    this.getContentPane().add(horizonScorllBar, BorderLayout.NORTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  @Override
  public String typeOfView() {
    return ViewType.VISUALVIEW.name();
  }

  @Override
  public String viewInString() {
    throw new IllegalArgumentException("Visualview does not support view in string.");
  }

  @Override
  public void getCurrentView(List<AbstractShape> shapeList) {
    this.revalidate();
    this.visuaViewPanel.setShapeList(shapeList);
    this.repaint();
  }

  private void setPanelX(int x) {
    this.visuaViewPanel.setPanelX(x);
  }

  private void setPanelY(int y) {
    this.visuaViewPanel.setPanelY(y);
  }

  @Override
  public ProcessInterface getModel() {
    return this.model;
  }

  @Override
  public String getOutputFile() {
    throw new IllegalArgumentException("Outputfile is not supported in textview.");
  }
}

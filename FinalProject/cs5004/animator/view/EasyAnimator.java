package cs5004.animator.view;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.ProcessImpl;
import cs5004.animator.model.ProcessInterface;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * This class models the final project.
 */
public final class EasyAnimator {

  /**
   * The main method of the project.
   * @param args the inputs.
   * @throws IOException when the args are not correct.
   */
  public static void main(String[] args) throws IOException {
    ProcessInterface model = new ProcessImpl();
    String inputFile = "";
    String outputFile = "";
    double speed = 0;
    String viewType = "";
    try {
      for (int i = 0; i < args.length; i += 2) {
        if (args[i].equalsIgnoreCase("-in")) {
          inputFile = args[i + 1];
        } else if (args[i].equalsIgnoreCase("-out")) {
          outputFile = args[i + 1];
        } else if (args[i].equalsIgnoreCase("-view")) {
          viewType = args[i + 1];
        } else if (args[i].equalsIgnoreCase("-speed")) {
          speed = Integer.parseInt(args[i + 1]);
        } else {
          throw new IllegalArgumentException("one of your arguments is not valid");
        }
      }

    } catch (IndexOutOfBoundsException e) {
      JOptionPane.showMessageDialog(
          null,
          "Command-Line argument error: Too many arguments " + "or too little arguments",
          "Argument Error",
          JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e2) {
      JOptionPane.showMessageDialog(
          null, "Speed is not an integer", "Data type error", JOptionPane.ERROR_MESSAGE);

    } catch (Exception e) {
      JOptionPane.showMessageDialog(
          null,
          "Something isn't right-Check your commandline arguments",
          "Unknown Error",
          JOptionPane.ERROR_MESSAGE);
    }

    if (inputFile.equalsIgnoreCase("") || !inputFile.contains(".txt")) {
      JOptionPane.showMessageDialog(
          null, "InputFile is invalid", "Input File Error", JOptionPane.ERROR_MESSAGE);
    }

    if (speed == 0) {
      speed = 1;
    }

    try {
      AnimationBuilder<ProcessInterface> builder =
          new ProcessImpl.OneBuilder(model);
      String filePath = new File("").getAbsolutePath();
      Readable readable = new FileReader(filePath + "/" + inputFile);
      AnimationReader.parseFile(readable, builder);

    } catch (IllegalStateException e) {
      JOptionPane.showMessageDialog(
          null, e.getMessage(), "Invalid Read Error", JOptionPane.ERROR_MESSAGE);
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(
          null, "Input File is invalid", "Input File Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException e) {
      JOptionPane.showMessageDialog(
          null, e.getMessage(), "Invalid Build Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
          null, e.getMessage(), "Invalid Build Error", JOptionPane.ERROR_MESSAGE);
    }
    model.setSpeed(speed);
    ViewInterface ourView = ViewFactory.getView(model, viewType, outputFile, speed);
    Controller controller = new Controller(ourView, model);
    controller.runAnimation();
  }
}

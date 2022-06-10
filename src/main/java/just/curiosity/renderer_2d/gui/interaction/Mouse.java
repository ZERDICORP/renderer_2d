package just.curiosity.renderer_2d.gui.interaction;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
  private boolean pressed;

  public boolean isPressed() {
    return pressed;
  }

  public void reset() {
    pressed = false;
  }

  @Override
  public void mouseDragged(MouseEvent mouseEvent) {
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {
    pressed = true;
  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {
    pressed = false;
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
  }

  @Override
  public void mouseMoved(MouseEvent mouseEvent) {
  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {
  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {
  }
}

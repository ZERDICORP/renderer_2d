package just.curiosity.renderer_2d;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import java.util.Random;
import just.curiosity.renderer_2d.constants.Const;
import just.curiosity.renderer_2d.gui.Window;
import just.curiosity.renderer_2d.gui.interaction.Keyboard;
import just.curiosity.renderer_2d.gui.interaction.Mouse;

public class Main {
  private static final int width;
  private static final int height;
  private static final Keyboard keyboard;
  private static final Mouse mouse;
  private static final int[] pixelBuffer;
  private static final Window window;
  private static boolean isRunning;

  static {
    width = 1000;
    height = 700;
    keyboard = new Keyboard();
    mouse = new Mouse();
    isRunning = true;

    final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    pixelBuffer = ((DataBufferInt) bufferedImage.getRaster()
      .getDataBuffer())
      .getData();

    window = new Window(bufferedImage, keyboard, mouse);
  }

  // This method is responsible for tracking interactions (keystrokes,
  // mouse click/movement).
  private static void interactionControl() {
    // Pressing escape will stop the application.
    if (keyboard.getCurrentKeyCode() == KeyEvent.VK_ESCAPE) {
      stop();
    }

    if (mouse.isPressed()) {
      System.out.println("Mouse pressed!");
    }

    // In order for us to react to the event only once, we need to reset
    // the mouse values.
    mouse.reset();
  }

  // This method is called on every frame.
  private static void updateAndDraw() {
    interactionControl();

    Arrays.fill(pixelBuffer, Const.BACKGROUND_COLOR_RGB);

    // Here you can write your logic (update state, draw pixels). As an
    // example, let's draw noise.
    final Random random = new Random();
    for (int i = 0; i < pixelBuffer.length; i++) {
      pixelBuffer[i] = new Color(
        random.nextInt(255),
        random.nextInt(255),
        random.nextInt(255)
      ).getRGB();
    }

    window.draw();
  }

  // Main loop.
  public static void start() {
    long start = System.currentTimeMillis();
    int frames = 0;

    while (isRunning) {
      long end = System.currentTimeMillis();
      if (end - start >= 1000) {
        System.out.println("FPS: " + frames);
        frames = 0;
        start = end;
      }

      updateAndDraw();

      frames++;
    }

    window.dispose();
  }

  private static void stop() {
    isRunning = false;
  }

  public static void main(String[] args) {
    start();
  }
}

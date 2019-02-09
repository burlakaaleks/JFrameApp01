package App.Tests;

import App.events.Event;
import App.events.types.MouseButtonEvent;
import App.layers.Layer;

import java.awt.*;

public class Example extends Layer {
    private int currentX, currentY, oldX, oldY;
    private Graphics graphics;

    public void onEvent(MouseButtonEvent e) {
        currentX = e.getX();
        currentY = e.getY();
        graphics.drawLine(oldX, oldY, currentX, currentY);
        onRender(graphics);
        oldX = currentX;
        oldY = currentY;
    }
}

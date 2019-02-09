package App.core;

import App.events.Event;
import App.events.types.MouseButtonEvent;
import App.events.types.MouseButtonPressed;
import App.events.types.MouseButtonReleased;
import App.layers.Layer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;


public class Window extends Canvas {
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private JFrame frame;
    private List<Layer> layerList = new ArrayList<Layer>();

    public Window(String name, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        init(name);
        render();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                MouseButtonPressed event = new MouseButtonPressed(e.getButton(), e.getX(), e.getY());
                onEvent(event);
            }

            public void mouseReleased(MouseEvent e) {
                MouseButtonReleased event = new MouseButtonReleased(e.getButton(), e.getX(), e.getY());
                onEvent(event);
            }
        });
    }


    private void init(String name) {
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private void render() {
        if (bufferStrategy == null)
            createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
        graphics = bufferStrategy.getDrawGraphics();
        graphics.drawRect(0, 0, getWidth(), getHeight());
        onRender(graphics);
        graphics.dispose();
        bufferStrategy.show();

    }

    private void onRender(Graphics g) {
        for (int i = 0; i < layerList.size(); i++) {
            layerList.get(i).onRender(g);
        }
    }

    private void onEvent(MouseButtonEvent event) {
        for (int i = layerList.size() - 1; i >= 0; i--) {
            layerList.get(i).onEvent(event);
        }
    }

    public void addLayer(Layer layer) {
        layerList.add(layer);
    }
}

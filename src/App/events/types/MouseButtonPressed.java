package App.events.types;

import App.events.Event;

public class MouseButtonPressed extends MouseButtonEvent {


    public MouseButtonPressed(int keyCode, int x, int y) {
        super(Type.MOUSE_PRESSED, keyCode, x, y);
    }
}

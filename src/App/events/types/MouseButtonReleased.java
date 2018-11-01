package App.events.types;

import App.events.Event;

public class MouseButtonReleased extends MouseButtonEvent {
    public MouseButtonReleased(int keyCode, int x, int y) {
        super(Type.MOUSE_RELEASED, keyCode, x, y);
    }
}

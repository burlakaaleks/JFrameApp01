package App.events.types;

public class MouseButtonPressed extends MouseButtonEvent {


    public MouseButtonPressed(int keyCode, int x, int y) {
        super(Type.MOUSE_PRESSED, keyCode, x, y);
    }
}

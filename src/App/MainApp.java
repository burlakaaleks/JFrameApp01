package App;

import App.Tests.Example;
import App.core.Window;

public class MainApp {
    public static void main(String[] args) {
        Window window1 = new Window("Test", 640, 480);
        window1.addLayer(new Example());
    }
}

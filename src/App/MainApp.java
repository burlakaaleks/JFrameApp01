package App;

import App.Tests.Example;
import App.core.Window;

public class MainApp {
    public static void main(String[] args) {
        Window window1 = new Window("New Window", 480, 360);
        window1.addLayer(new Example());
    }
}

package App.Tests;

import App.events.Event;
import App.layers.Layer;

public class Example extends Layer {

    public void onEvent(Event e) {
        System.out.println(e);
    }
}

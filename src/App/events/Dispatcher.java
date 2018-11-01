package App.events;

public class Dispatcher {
    public Event event;

    public Dispatcher(Event event) {
        this.event = event;
    }

    public void dispatch (Event.Type type, EventHandler handler){
        if(event.handled) return;
        if(event.getType() == type)
            handler.handle(event);

    }
}

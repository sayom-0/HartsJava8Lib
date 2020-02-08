package hart.Valkyrie.objects.eventbuttonmanager;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;

public abstract class MethodParser<N extends Node, E extends Event>
{
	
	public abstract N link(N n, EventHandler<E> e);
}

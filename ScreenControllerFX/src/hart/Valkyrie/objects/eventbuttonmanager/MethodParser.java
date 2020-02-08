package hart.Valkyrie.objects.eventbuttonmanager;

import hart.Valkyrie.SuperConductor;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;

public abstract class MethodParser<N extends Node, E extends Event>implements SuperConductor
{
	public abstract N link(N n, EventHandler<E> e);
}

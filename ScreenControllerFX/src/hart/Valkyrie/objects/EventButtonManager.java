package hart.Valkyrie.objects;

import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EventButtonManager
{
	private final static double EVENTBUTTONMANAGER_VERSION = 1.1;
	
	private NamedArrayList buttons;
	private NamedArrayList events;
	
	public EventButtonManager()
	{
		super();
	}
	
	public NamedArrayList exportButtons()
	{
		NamedArrayList xbuttons = buttons;
		return xbuttons;
	}
	
	public void importButtons(NamedArrayList ibuttons)
	{
		buttons = ibuttons;
	}
	
	public NamedArrayList exportEvents()
	{
		NamedArrayList xEvents = events;
		return xEvents;
	}
	
	public void importEvents(NamedArrayList iEvents)
	{
		events = iEvents;
	}
	
	public Button getButton(String si)
	{
		return (Button) buttons.get(si);
	}
	
	public void replaceButton(String fname, Button ibutton)
	{
		buttons.set(fname, ibutton);
	}

	public void makeButton(String fname, Button ibutton)
	{
		buttons.add(fname, ibutton);
	}
	
	public EventHandler getEvent(String si)
	{
		return (EventHandler) events.get(si);
	}
	
	public void replaceEvent(String fname, EventHandler iEvent)
	{
		events.set(fname, iEvent);
	}

	public void makeEvent(String fname, EventHandler iEvent)
	{
		events.add(fname, iEvent);
	}
	
	public void makeLink(String buttonName, String eventName)
	{
		((Button) buttons.get(buttonName)).setOnAction((EventHandler) events.get(eventName));
	}
	
	public void removeLink(String buttonName)
	{
		((Button) buttons.get(buttonName)).setOnAction(null);
	}

	public static double getEventbuttonmanagerVersion()
	{
		return EVENTBUTTONMANAGER_VERSION;
	}
	
	
	
}

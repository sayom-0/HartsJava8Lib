package hart.Valkyrie.objects;

import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import javafx.event.ActionEvent;
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
		buttons = new NamedArrayList();
		events = new NamedArrayList();
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

	public Button getButton(String si) throws NonExistantDataException
	{
		return (Button) buttons.get(si);
	}

	public void replaceButton(String fname, Button ibutton)
	{
		buttons.set(fname, ibutton);
	}

	public void makeButton(String fname, Button ibutton) throws DuplicateNameException
	{
		buttons.add(fname, ibutton);
	}

	public void makeButton(String fname, Button ibutton, EventHandler<ActionEvent> eventh) throws DuplicateNameException
	{
		ibutton.setOnAction(eventh);
		buttons.add(fname, ibutton);
	}

	public void makeButton(String fname, Button ibutton, String eventst) throws DuplicateNameException, NonExistantDataException
	{
		ibutton.setOnAction((EventHandler<ActionEvent>) events.get(eventst));
		buttons.add(fname, ibutton);
	}

	public EventHandler<?> getEvent(String si) throws NonExistantDataException
	{
		return (EventHandler<?>) events.get(si);
	}

	public void replaceEvent(String fname, EventHandler<?> iEvent)
	{
		events.set(fname, iEvent);
	}

	public void makeEvent(String fname, EventHandler<?> iEvent) throws DuplicateNameException
	{
		events.add(fname, iEvent);
	}

	public void makeLink(String buttonName, String eventName) throws NonExistantDataException
	{
		((Button) buttons.get(buttonName)).setOnAction((EventHandler<ActionEvent>) events.get(eventName));
	}

	public void removeLink(String buttonName) throws NonExistantDataException
	{
		((Button) buttons.get(buttonName)).setOnAction(null);
	}

	public static double getEventbuttonmanagerVersion()
	{
		return EVENTBUTTONMANAGER_VERSION;
	}

}

/** EventButtonManager (EBM) is a manager for buttons and eventhandlers that allows you to store, manage, link and unlink eventhandlers and buttons
 *
 * @author Logan Hart
 * @version V1.2-1.16.20
 */
package hart.Valkyrie.objects;

import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EventButtonManager
{
	private final static double EVENTBUTTONMANAGER_VERSION = 1.2;

	private NamedArrayList<Button> buttons;
	private NamedArrayList<EventHandler> events;

	public EventButtonManager()
	{
		super();
		buttons = new NamedArrayList<Button>();
		events = new NamedArrayList<EventHandler>();
	}

	/** @return Returns the NAL for Button Objects */
	public NamedArrayList<Button> exportButtons()
	{
		return buttons;
	}

	/** @param ibuttons Import a NAL from Buttons from another EBM */
	public void importButtons(NamedArrayList<Button> ibuttons)
	{
		buttons = ibuttons;
	}

	/** @return Returns the NAL for Event Handlers */
	public NamedArrayList<EventHandler> exportEvents()
	{
		return events;
	}

	/** @param iEvents Import a Event Handler NAL from another EBM */
	public void importEvents(NamedArrayList<EventHandler> iEvents)
	{
		events = iEvents;
	}

	/** @return Returns the button registered under that name */
	public Button getButton(String si) throws NonExistantDataException
	{
		return buttons.get(si);
	}

	/**
	 * @param fname   Name of button to be replaced
	 * @param ibutton Button to replace with
	 */
	public void replaceButton(String fname, Button ibutton) throws NonExistantDataException
	{
		buttons.set(fname, ibutton);
	}

	/**
	 * @param fname   Name to register the button under
	 * @param ibutton button to register
	 */
	public void makeButton(String fname, Button ibutton) throws DuplicateNameException
	{
		buttons.add(fname, ibutton);
	}

	/**
	 * @param fname   Name to register the button under
	 * @param ibutton button to register
	 * @param eventh  Event to link to button
	 */
	public void makeButton(String fname, Button ibutton, EventHandler eventh) throws DuplicateNameException
	{
		ibutton.setOnAction(eventh);
		buttons.add(fname, ibutton);
	}

	/**
	 * @param fname   Name to register the button under
	 * @param ibutton button to register
	 * @param eventst String to link button to
	 */
	public void makeButton(String fname, Button ibutton, String eventst)
			throws DuplicateNameException, NonExistantDataException
	{
		ibutton.setOnAction(events.get(eventst));
		buttons.add(fname, ibutton);
	}

	/**
	 * @param si String to search EventHandler NAL form
	 */
	public EventHandler getEvent(String si) throws NonExistantDataException
	{
		return events.get(si);
	}

	/**
	 * @param fname  Name of Event to be replaced
	 * @param iEvent new event
	 */
	public void replaceEvent(String fname, EventHandler iEvent) throws NonExistantDataException
	{
		events.set(fname, iEvent);
	}

	/**
	 * @param fname  Name of new Event
	 * @param iEvent Event Object to be saved
	 */
	public void makeEvent(String fname, EventHandler iEvent) throws DuplicateNameException
	{
		events.add(fname, iEvent);
	}

	/**
	 * Link two pre-registered buttons and event
	 * 
	 * @param buttonName Name of button to be linked
	 * @param eventName  Name of event to be linked
	 */
	public void makeLink(String buttonName, String eventName) throws NonExistantDataException
	{
		(buttons.get(buttonName)).setOnAction(events.get(eventName));
	}

	/** @param buttonName String name of button to be unlinked */
	public void removeLink(String buttonName) throws NonExistantDataException
	{
		(buttons.get(buttonName)).setOnAction(null);
	}

	public static double getEventbuttonmanagerVersion()
	{
		return EVENTBUTTONMANAGER_VERSION;
	}

}

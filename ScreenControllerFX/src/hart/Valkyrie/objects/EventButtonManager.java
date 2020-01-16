/** Description of MyClass 
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

	public NamedArrayList<Button> exportButtons()
	{
		return buttons;
	}

	public void importButtons(NamedArrayList<Button> ibuttons)
	{
		buttons = ibuttons;
	}

	public NamedArrayList<EventHandler> exportEvents()
	{
		return events;
	}

	public void importEvents(NamedArrayList<EventHandler> iEvents)
	{
		events = iEvents;
	}

	public Button getButton(String si) throws NonExistantDataException
	{
		return buttons.get(si);
	}

	public void replaceButton(String fname, Button ibutton) throws NonExistantDataException
	{
		buttons.set(fname, ibutton);
	}

	public void makeButton(String fname, Button ibutton) throws DuplicateNameException
	{
		buttons.add(fname, ibutton);
	}

	public void makeButton(String fname, Button ibutton, EventHandler eventh) throws DuplicateNameException
	{
		ibutton.setOnAction(eventh);
		buttons.add(fname, ibutton);
	}

	public void makeButton(String fname, Button ibutton, String eventst) throws DuplicateNameException, NonExistantDataException
	{
		ibutton.setOnAction((EventHandler) events.get(eventst));
		buttons.add(fname, ibutton);
	}

	public EventHandler getEvent(String si) throws NonExistantDataException
	{
		return events.get(si);
	}

	public void replaceEvent(String fname, EventHandler iEvent) throws NonExistantDataException
	{
		events.set(fname, iEvent);
	}

	public void makeEvent(String fname, EventHandler iEvent) throws DuplicateNameException
	{
		events.add(fname, iEvent);
	}

	public void makeLink(String buttonName, String eventName) throws NonExistantDataException
	{
		(buttons.get(buttonName)).setOnAction((EventHandler) events.get(eventName));
	}

	public void removeLink(String buttonName) throws NonExistantDataException
	{
		(buttons.get(buttonName)).setOnAction(null);
	}

	public static double getEventbuttonmanagerVersion()
	{
		return EVENTBUTTONMANAGER_VERSION;
	}

}

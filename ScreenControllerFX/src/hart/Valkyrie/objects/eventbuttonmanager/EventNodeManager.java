/** EventButtonManager (EBM) is a manager for nodes and eventhandlers that allows you to store, manage, link and unlink eventhandlers and nodes
 *
 * @author Logan Hart
 * @version V2.0
 */
package hart.Valkyrie.objects.eventbuttonmanager;

//TODO update javadoc
import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.objects.NamedLists.NamedArrayList;
import hart.Valkyrie.SuperConductor;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class EventNodeManager<T extends Node, E extends Event, Y extends MethodParser<T, E>> implements SuperConductor
{
	private final static double EVENTBUTTONMANAGER_VERSION = 2.0;

	private NamedArrayList<T> nodes;
	private NamedArrayList<EventHandler<E>> events;
	private Y operator;

	public EventNodeManager(Y y)
	{
		super();
		nodes = new NamedArrayList<>();
		events = new NamedArrayList<>();
		operator = y;
	}

	/** @return Returns the NAL for T Objects */
	public NamedArrayList<T> exportnodes()
	{
		return nodes;
	}

	/** @param inodes Import a NAL from nodes from another EBM */
	public void importNodes(NamedArrayList<T> inodes)
	{
		nodes = inodes;
	}

	/** @return Returns the NAL for Event Handlers */
	public NamedArrayList<EventHandler<E>> exportEvents()
	{
		return events;
	}

	/** @param iEvents Import a Event Handler NAL from another EBM */
	public void importEvents(NamedArrayList<EventHandler<E>> iEvents)
	{
		events = iEvents;
	}

	/**
	 * @return Returns the T registered under that name
	 * @throws NonExistantDataException
	 */
	public T getNode(String si) throws NonExistantDataException
	{
		return nodes.get(si);
	}

	/**
	 * @param fname   Name of T to be replaced
	 * @param ibutton T to replace with
	 * @throws NonExistantDataException
	 */
	public void replaceNode(String fname, T ibutton) throws NonExistantDataException
	{
		nodes.set(fname, ibutton);
	}

	/**
	 * @param fname   Name to register the T under
	 * @param ibutton T to register
	 * @throws DuplicateNameException
	 * @return T you added
	 * @throws NonExistantDataException
	 */
	public T makeNode(String fname, T ibutton) throws DuplicateNameException, NonExistantDataException
	{
		nodes.add(fname, ibutton);
		return nodes.get(fname);
	}

	/**
	 * @param fname   Name to register the T under
	 * @param ibutton T to register
	 * @param eventh  Event to link to T
	 * @return
	 * @throws DuplicateNameException
	 * @throws NonExistantDataException
	 */
	public T makeNode(String fname, T ibutton, EventHandler<E> eventh)
			throws DuplicateNameException, NonExistantDataException
	{
		// ibutton.setOnAction(eventh);
		nodes.add(fname, operator.link(ibutton, eventh));
		return nodes.get(fname);
	}

	/**
	 * @param fname   Name to register the T under
	 * @param ibutton T to register
	 * @param eventst String to link T to
	 * @return
	 * @throws NonExistantDataException
	 * @throws DuplicateNameException
	 */
	public T makeNode(String fname, T ibutton, String eventst) throws NonExistantDataException, DuplicateNameException
	{
		// ibutton.setOnAction(events.get(eventst));
		nodes.add(fname, operator.link(ibutton, events.get(eventst)));
		return nodes.get(fname);
	}

	/**
	 * @param si String to search EventHandler NAL form
	 * @throws NonExistantDataException
	 */
	public EventHandler<E> getEvent(String si) throws NonExistantDataException
	{
		return events.get(si);
	}

	/**
	 * @param fname  Name of Event to be replaced
	 * @param iEvent new event
	 * @throws NonExistantDataException
	 */
	public void replaceEvent(String fname, EventHandler<E> iEvent) throws NonExistantDataException
	{
		events.set(fname, iEvent);
	}

	/**
	 * @param fname  Name of new Event
	 * @param iEvent Event Object to be saved
	 * @throws DuplicateNameException
	 * @throws NonExistantDataException
	 */
	public EventHandler<E> makeEvent(String fname, EventHandler<E> iEvent)
			throws DuplicateNameException, NonExistantDataException
	{
		events.add(fname, iEvent);
		return events.get(fname);
	}

	/**
	 * Link two pre-registered nodes and event
	 * 
	 * @param buttonName Name of T to be linked
	 * @param eventName  Name of event to be linked
	 * @throws NonExistantDataException
	 */
	public void makeLink(String buttonName, String eventName) throws NonExistantDataException
	{
		nodes.set(buttonName, operator.link(nodes.get(buttonName), events.get(eventName)));
		// nodes.get(buttonName).setOnAction(events.get(eventName));
	}

	/**
	 * @param buttonName String name of T to be unlinked
	 * @throws NonExistantDataException
	 */
	public void removeLink(String buttonName) throws NonExistantDataException
	{
		nodes.set(buttonName, operator.link(nodes.get(buttonName), null));
		// nodes.get(buttonName).setOnAction(null);
	}

	public static double getEventbuttonmanagerVersion()
	{
		return EVENTBUTTONMANAGER_VERSION;
	}

	@Override
	public void deConstruct()
	{
		nodes.deConstruct();
		nodes = null;
		events.deConstruct();
		events = null;
		operator.deConstruct();
		operator = null;
	}

}

/** EventButtonManager (EBM) is a manager for nodes and eventhandlers that allows you to store, manage, link and unlink eventhandlers and nodes
 *
 * @author Logan Hart
 * @version V2.0
 */
package hart.Valkyrie.objects;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.objects.NamedLists.NamedArrayList;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;

public class EventNodeManager<T extends Node>
{
	private final static double EVENTBUTTONMANAGER_VERSION = 2.0;

	private NamedArrayList<T> nodes;
	private NamedArrayList<EventHandler> events;
	private String tieMethod;

	public EventNodeManager(String method)
	{
		super();
		nodes = new NamedArrayList<>();
		events = new NamedArrayList<>();
		tieMethod = method;
	}

	/** @return Returns the NAL for T Objects */
	public NamedArrayList<T> exportnodes()
	{
		return nodes;
	}

	/** @param inodes Import a NAL from nodes from another EBM */
	public void importnodes(NamedArrayList<T> inodes)
	{
		nodes = inodes;
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

	/**
	 * @return Returns the T registered under that name
	 * @throws NonExistantDataException
	 */
	public T getButton(String si) throws NonExistantDataException
	{
		return nodes.get(si);
	}

	/**
	 * @param fname   Name of T to be replaced
	 * @param ibutton T to replace with
	 * @throws NonExistantDataException
	 */
	public void replaceButton(String fname, T ibutton) throws NonExistantDataException
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
	public T makeButton(String fname, T ibutton) throws DuplicateNameException, NonExistantDataException
	{
		nodes.add(fname, ibutton);
		return nodes.get(fname);
	}

	/**
	 * @param fname   Name to register the T under
	 * @param ibutton T to register
	 * @param eventh  Event to link to T
	 * @return Object made
	 * @throws DuplicateNameException
	 * @throws NonExistantDataException
	 */
	public T makeButton(String fname, T ibutton, EventHandler eventh)
			throws DuplicateNameException, NonExistantDataException
	{
		Binding binding = new Binding();
		binding.setProperty("ibutton", ibutton);
		binding.setProperty("eventh", eventh);
		GroovyShell shell = new GroovyShell(binding);
		shell.evaluate("(ibutton)." + tieMethod + "(eventh);");
		nodes.add(fname, ibutton);
		return nodes.get(fname);
	}

	/**
	 * @param fname   Name to register the T under
	 * @param ibutton T to register
	 * @param eventst String to link T to
	 * @return Object made
	 * @throws NonExistantDataException
	 * @throws DuplicateNameException
	 */
	public T makeButton(String fname, T ibutton, String eventst) throws NonExistantDataException, DuplicateNameException
	{
		Binding binding = new Binding();
		binding.setProperty("ibutton", ibutton);
		binding.setProperty("events", events);
		binding.setProperty("eventst", eventst);
		GroovyShell shell = new GroovyShell(binding);
		shell.evaluate("(ibutton)" + tieMethod + "(events.get(eventst));");
		nodes.add(fname, ibutton);
		return nodes.get(fname);
	}

	/**
	 * @param si String to search EventHandler NAL form
	 * @throws NonExistantDataException
	 */
	public EventHandler getEvent(String si) throws NonExistantDataException
	{
		return events.get(si);
	}

	/**
	 * @param fname  Name of Event to be replaced
	 * @param iEvent new event
	 * @throws NonExistantDataException
	 */
	public void replaceEvent(String fname, EventHandler iEvent) throws NonExistantDataException
	{
		events.set(fname, iEvent);
	}

	/**
	 * @param fname  Name of new Event
	 * @param iEvent Event Object to be saved
	 * @throws DuplicateNameException
	 * @throws NonExistantDataException
	 */
	public EventHandler makeEvent(String fname, EventHandler iEvent)
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
		Binding binding = new Binding();
		binding.setProperty("buttonName", buttonName);
		binding.setProperty("eventName", eventName);
		
		binding.setProperty("nodes", nodes);
		binding.setProperty("events", events);
		GroovyShell shell = new GroovyShell(binding);
		shell.evaluate("(nodes.get(buttonName))" + tieMethod + "(events.get(eventName));");
	}

	/**
	 * @param buttonName String name of T to be unlinked
	 * @throws NonExistantDataException
	 */
	public void removeLink(String buttonName) throws NonExistantDataException
	{
		Binding binding = new Binding();
		binding.setProperty("buttonName", buttonName);
		binding.setProperty("nodes", nodes);
		GroovyShell shell = new GroovyShell(binding);
		shell.evaluate("(nodes.get(buttonName))" + tieMethod + "(null);");
	}

	public static double getEventNodeManagerVersion()
	{
		return EVENTBUTTONMANAGER_VERSION;
	}

}

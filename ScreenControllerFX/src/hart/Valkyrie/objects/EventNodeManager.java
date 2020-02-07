/** EventButtonManager (EBM) is a manager for nodes and eventhandlers that allows you to store, manage, link and unlink eventhandlers and nodes
 *
 * @author Logan Hart
 * @version V2.0
 */
package hart.Valkyrie.objects;

import java.io.File;
import java.io.IOException;

import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.objects.NamedLists.NamedArrayList;
import hart.Valkyrie.util.DataManager;
import hart.Valkyrie.util.GenericData;
import javafx.event.EventHandler;
import javafx.scene.Node;
import net.openhft.compiler.CompilerUtils;

public class EventNodeManager<T extends Node>
{
	private final static double EVENTBUTTONMANAGER_VERSION = 2.0;

	private NamedArrayList<T> nodes;
	private NamedArrayList<EventHandler> events;
	private String tieMethod;
	private DataManager<T> ns;
	private DataManager<EventHandler> es;
	private GenericData<T> s;
	private GenericData<EventHandler> e;

	public EventNodeManager(String method) throws IOException
	{
		super();
		nodes = new NamedArrayList<>();
		events = new NamedArrayList<>();
		tieMethod = method;

		ns = new DataManager<>(new File("Ns.nls"));
		ns.DataLine = nodes;

		es = new DataManager<>(new File("Es.nls"));
		es.DataLine = events;

		s = new GenericData<>(new File("S.nls"));
		e = new GenericData<>(new File("E.nls"));
	}

	private void tiePrep()
	{
		ns.DataLine = nodes;
		es.DataLine = events;

		ns.save();
		es.save();
		s.save();
		e.save();
	}

	private void tiePost()
	{
		ns.load();
		es.load();
		s.load();
		e.load();
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
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public T makeButton(String fname, T ibutton, EventHandler eventh) throws DuplicateNameException,
			NonExistantDataException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		tiePrep();

		String className = "mypackage.MyClass";
		String javaCode = "package mypackage;\n" + "public class MyClass implements Runnable {\n"
				+ "    public void run() {\n"
				+ "DataManager ns = new DataManager(new File(\"Ns.nls\"));DataManager es = new DataManager(new File(\"Es.nls\"));ns.load();es.load();ibutton."
				+ tieMethod + "(eventh);ns.save();es.save();\n" + "    }\n" + "}\n" + "";
		boolean sDM = CompilerUtils.addClassPath("src/hart/Valkyrie/util/DataManager.java");
		System.out.println(sDM);
		Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
		Runnable runner = (Runnable) aClass.newInstance();
		runner.run();

		tiePost();

		ibutton = s.DataLine.get(fname);

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
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public T makeButton(String fname, T ibutton, String eventst) throws NonExistantDataException,
			DuplicateNameException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		tiePrep();

		String className = "mypackage.MyClass";
		String javaCode = "package mypackage;\n" + "public class MyClass implements Runnable {\n"
				+ "    public void run() {\n" + "ibutton." + tieMethod + "(events.get(eventst));\n" + "    }\n" + "}\n";
		Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
		Runnable runner = (Runnable) aClass.newInstance();
		runner.run();

		tiePost();

		ibutton = s.DataLine.get(fname);

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
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void makeLink(String buttonName, String eventName)
			throws NonExistantDataException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		tiePrep();

		String className = "mypackage.MyClass";
		String javaCode = "package mypackage;\n" + "public class MyClass implements Runnable {\n"
				+ "    public void run() {\n" + "nodes.get(buttonName)." + tieMethod + "(events.get(eventName));\n"
				+ "    }\n" + "}\n";
		Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
		Runnable runner = (Runnable) aClass.newInstance();
		runner.run();

		tiePost();

		nodes.set(buttonName, ns.DataLine.get(buttonName));
	}

	/**
	 * @param buttonName String name of T to be unlinked
	 * @throws NonExistantDataException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public void removeLink(String buttonName)
			throws NonExistantDataException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		tiePrep();

		String className = "mypackage.MyClass";
		String javaCode = "package mypackage;\n" + "public class MyClass implements Runnable {\n"
				+ "    public void run() {\n" + "nodes.get(buttonName)." + tieMethod + "(null);\n" + "    }\n" + "}\n";
		Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
		Runnable runner = (Runnable) aClass.newInstance();
		runner.run();

		tiePost();

		nodes.set(buttonName, ns.DataLine.get(buttonName));
	}

	public static double getEventNodeManagerVersion()
	{
		return EVENTBUTTONMANAGER_VERSION;
	}

}

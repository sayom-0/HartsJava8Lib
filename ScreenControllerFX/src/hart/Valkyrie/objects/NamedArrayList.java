//Author: Logan Xander Hart

package hart.Valkyrie.objects;

import java.io.Serializable;
import java.util.ArrayList;

import hart.Valkyrie.util.Utils;

public class NamedArrayList implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4692623948131600984L;
	private ArrayList<Object> NAL;
	private ArrayList<Object> DAL;

	private final static double NAMEDARRAYLIST_VERSION = 1.1;
	
	public NamedArrayList()
	{
		super();
		NAL = new ArrayList<Object>();
		DAL = new ArrayList<Object>();
	}

	public void add(String name, Object data)
	{
		NAL.add(name);
		DAL.add(data);
	}

	public Object get(String name)
	{
		return DAL.get(Utils.searchArrayList(NAL, name));
	}

	public void set(String name, Object data)
	{
		DAL.set(Utils.searchArrayList(NAL, name), data);
	}

	public void remove(String name)
	{
		DAL.remove(Utils.searchArrayList(NAL, name));
		NAL.remove(Utils.searchArrayList(NAL, name));
	}

	public static double getUtilsVersion()
	{
		return NAMEDARRAYLIST_VERSION;
	}

}

//Author: Logan Xander Hart

package hart.Valkyrie.objects;

import java.io.Serializable;
import java.util.ArrayList;
import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.util.Utils;

public class NamedArrayList<T> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4692623948131600984L;
	private ArrayList<String> NAL;
	private ArrayList<T> DAL;

	private final static double NAMEDARRAYLIST_VERSION = 2.0;

	public NamedArrayList()
	{
		super();
		NAL = new ArrayList<String>();
		DAL = new ArrayList<T>();
	}

	public void add(String name, T data) throws DuplicateNameException
	{
		if (Utils.searchArrayList(NAL, name) == -1)
		{
			NAL.add(name);
			DAL.add(data);
		} else
		{
			throw new DuplicateNameException("Name Already Registered in NAL.NAL");
		}

	}

	public T get(String name) throws NonExistantDataException
	{
		int x = Utils.searchArrayList(NAL, name);
		if (x == -1)
		{
			throw new NonExistantDataException("No data is registered in the NAL.NAL under that String value");
		} else
		{
			return DAL.get(x);
		}

	}

	public void set(String name, T data) throws NonExistantDataException
	{
		if (Utils.searchArrayList(NAL, name) == -1)
		{
			throw new NonExistantDataException("No data is registered in the NAL.NAL under that String value");
		} else
		{
			DAL.set(Utils.searchArrayList(NAL, name), data);
		}
	}

	public void remove(String name) throws NonExistantDataException
	{
		int x = Utils.searchArrayList(NAL, name);
		if (x == -1)
		{
			throw new NonExistantDataException("No data is registered in the NAL.NAL under that String value");
		} else
		{
			DAL.remove(x);
			NAL.remove(x);
		}
	}

	public boolean contains(String name)
	{
		return NAL.contains(name);
	}

	public boolean isEmpty()
	{
		return NAL.isEmpty() && DAL.isEmpty() ? true : false;
	}

	public static double getUtilsVersion()
	{
		return NAMEDARRAYLIST_VERSION;
	}

}

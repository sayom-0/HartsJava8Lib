/**  
 *
 * @author Logan Hart
 * @version V2.3-1.16.20
 */
package hart.Valkyrie.objects;

import java.io.Serializable;
import java.util.ArrayList;
import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.util.Utils;

/**
 * The NamedArrayList(NAL) Class is meant to port the functionality of an
 * ArrayList into a String indexed ArrayList and is heavily used throughout this
 * Library, It works by using two normal ArrayLists and adding entrys to both
 * while relying on them being in-sync to get data back from by scanning the
 * first for a string value and using the same index on a second array list with
 * the actual data.
 */
public class NamedArrayList<T> implements Serializable
{
	private static final long serialVersionUID = 4692623948131600984L;
	private ArrayList<String> NAL;
	private ArrayList<T> DAL;

	private final static double NAMEDARRAYLIST_VERSION = 2.3;

	public NamedArrayList()
	{
		super();
		NAL = new ArrayList<String>();
		DAL = new ArrayList<T>();
	}

	/**
	 * Add data to the NAL
	 * 
	 * @param name Name of new Data
	 * @param data Data to be added to the NAL
	 */
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

	/**
	 * Get Data from the NAL
	 * 
	 * @param name Name of Data to Fetch
	 */
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

	/**
	 * Set a Already Defined Name to a Different Value
	 * 
	 * @param name Name of data to replace
	 * @param data Data to write over DAL
	 */
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

	/**
	 * Remove a Value from the NAL
	 *
	 * @param name Name of data to remove
	 */
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

	/**
	 * See if anything is registered in the NAL under a name
	 * 
	 * @param name Name to check for
	 */
	public boolean contains(String name)
	{
		return NAL.contains(name);
	}

	/**
	 * Checks if the Internal NAL and DAL are empty (If one is empty both should be,
	 * but just in case this was somehow horridly broken...)
	 */
	public boolean isEmpty()
	{
		return NAL.isEmpty() && DAL.isEmpty() ? true : false;
	}

	/** Export the Names of all data in AL<String> Format */
	public ArrayList<String> exportNAL()
	{
		return NAL;
	}

	/** Export the Data in NAL in AL<T> Format */
	public ArrayList<T> exportDAL()
	{
		return DAL;
	}

	/**
	 * Import data from another NAL
	 * 
	 * @param array NAL to import data from
	 */
	public void merdge(NamedArrayList<T> array)
	{
		int x = 0;
		ArrayList<String> INAL = array.exportNAL();
		ArrayList<T> IDAL = array.exportDAL();
		while (INAL.size() != x)
		{
			NAL.add(INAL.get(x));
			x++;
		}
		x = 0;
		while (IDAL.size() != x)
		{
			DAL.add(IDAL.get(x));
			x++;
		}

	}

	/** Returns the size of NAL */
	public int size()
	{
		return NAL.size();
	}

	@Override
	public String toString()
	{
		String output = " | NAL | " + getNALVersion() + " | \n";
		int x = 0;

		while (NAL.size() != x)
		{
			output += "Name : " + NAL.get(x) + " Data : " + DAL.get(x).toString() + " \n";
			x++;
		}

		return output;
	}

	public static double getNALVersion()
	{
		return NAMEDARRAYLIST_VERSION;
	}

}

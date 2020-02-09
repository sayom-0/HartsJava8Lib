package hart.Valkyrie.objects;

/**  
*
* @author Logan Hart
* @version V2.3-1.16.20
*/

import java.io.Serializable;
import java.util.List;

import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.SuperConductor;
import hart.Valkyrie.util.Utils;

/**
* The NamedArrayList(NAL) Class is meant to port the functionality of an
* ArrayList into a String indexed ArrayList and is heavily used throughout this
* Library, It works by using two normal ArrayLists and adding entry to both
* while relying on them being in-sync to get data back from by scanning the
* first for a string value and using the same index on a second array list with
* the actual data. ArrayList is configured to auto trim every time that data is
* accessed.
* TODO Add iterator and stream support
*/
public abstract class NamedList<T> implements Serializable, SuperConductor
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2912279328261778349L;
	protected List<String> NAL;
	protected List<T> DAL;

	private final static double NAMEDLIST_VERSION = 3.0;

	/**
	 * Add data to the NAL
	 * 
	 * @param name Name of new Data
	 * @param data Data to be added to the NAL
	 * @throws DuplicateNameException 
	 */
	public void add(String name, T data) throws DuplicateNameException 
	{
		if (Utils.searchList(this.NAL, name) == -1)
		{
			this.NAL.add(name);
			this.DAL.add(data);
		} else
		{
			throw new DuplicateNameException("Name Already Registered in NAL.NAL");
		}
	}

	/**
	 * Get Data from the NAL
	 * 
	 * @param name Name of Data to Fetch
	 * @throws NonExistantDataException 
	 */
	public T get(String name) throws NonExistantDataException 
	{
		int x = Utils.searchList(NAL, name);
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
	 * @throws NonExistantDataException 
	 */
	public void set(String name, T data) throws NonExistantDataException 
	{
		if (Utils.searchList(NAL, name) == -1)
		{
			throw new NonExistantDataException("No data is registered in the NAL.NAL under that String value");
		} else
		{
			this.DAL.set(Utils.searchList(NAL, name), data);
		}
	}

	/**
	 * Remove a Value from the NAL
	 *
	 * @param name Name of data to remove
	 * @throws NonExistantDataException 
	 */
	public void remove(String name) throws NonExistantDataException
	{
		int x = Utils.searchList(NAL, name);
		if (x == -1)
		{
			throw new NonExistantDataException("No data is registered in the NAL.NAL under that String value");
		} else
		{
			this.DAL.remove(x);
			this.NAL.remove(x);
		}
	}

	/**
	 * See if anything is registered in the NAL under a name
	 * 
	 * @param name Name to check for
	 */
	public boolean contains(String name)
	{
		return this.NAL.contains(name);
	}

	/**
	 * Checks if the Internal NAL and DAL are empty (If one is empty both should be,
	 * but just in case this was somehow horridly broken...)
	 */
	public boolean isEmpty()
	{
		return this.NAL.isEmpty() && DAL.isEmpty() ? true : false;
	}

	/** Export the Names of all data in AL<String> Format */
	public List<String> exportNAL()
	{
		return this.NAL;
	}

	/** Export the Data in NAL in AL<T> Format */
	public List<T> exportDAL()
	{
		return DAL;
	}

	/**
	 * Import data from another NAL
	 * 
	 * @param array NAL to import data from
	 */
	public void merdge(NamedList<T> array)
	{
		int x = 0;
		List<String> INAL = array.exportNAL();
		List<T> IDAL = array.exportDAL();
		while (INAL.size() != x)
		{
			this.NAL.add(INAL.get(x));
			x++;
		}
		x = 0;
		while (IDAL.size() != x)
		{
			this.DAL.add(IDAL.get(x));
			x++;
		}

	}

	/** Returns the size of NAL */
	public int size()
	{
		return this.NAL.size();
	}
	/** Returns basic output for each registered data key*/
	@Override
	public String toString()
	{
		String output = " | NL | " + getNLVersion() + " | \n";
		int x = 0;

		while (NAL.size() != x)
		{
			output += "Name : \"" + this.NAL.get(x) + "\" Data : " + this.DAL.get(x).toString() + " \n";
			x++;
		}

		return output;
	}

	public static double getNLVersion()
	{
		return NAMEDLIST_VERSION;
	}
	
	@Override
	public void deConstruct()
	{
		NAL = null;
		DAL = null;
	}

}


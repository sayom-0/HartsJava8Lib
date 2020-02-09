/**  
 *
 * @author Logan Hart
 * @version V2.3-1.16.20
 */
package hart.Valkyrie.objects.NamedLists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.objects.NamedList;
import hart.Valkyrie.util.Utils;

/**
 * The NamedArrayList(NAL) Class is meant to port the functionality of an
 * ArrayList into a String indexed ArrayList and is heavily used throughout this
 * Library, It works by using two normal ArrayLists and adding entry to both
 * while relying on them being in-sync to get data back from by scanning the
 * first for a string value and using the same index on a second array list with
 * the actual data. ArrayList is configured to auto trim every time that data is
 * accessed.
 * TODO add trimming support
 */
public class NamedArrayList<T> extends NamedList<T> implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1883773464711034262L;

	public NamedArrayList()
	{
		NAL = new ArrayList<String>();
		DAL = new ArrayList<T>();
	}
}

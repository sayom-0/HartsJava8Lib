/** Description of MyClass 
 *
 * @author Logan Hart
 * @version V1.1-1.16.20
 */

package hart.Valkyrie.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import hart.Valkyrie.objects.NamedArrayList;

public class DataManager
{
	private final static double DATAMANAGER_VERSION = 1.1;

	private FileInputStream fis;
	private ObjectInputStream ois;

	private FileOutputStream saveos;
	private ObjectOutputStream saveoos;
	/**DataLine is a Public NAL that the file is copyed into*/
	public NamedArrayList DataLine;
	
	private File iofile;
	
	/**Constructor for DataManager, this links the DataManager's OIS and OOS to the file
	 * 
	 * @param ifile A file object
	 */

	public DataManager(File file)
	{
		DataLine = new NamedArrayList();
		iofile = file;
	}
	
	/**The Load method will copy the NAL from a File into the public DataLine Field*/

	public void load()
	{
		try
		{
			fis = new FileInputStream(iofile);
			ois = new ObjectInputStream(fis);
			DataLine = (NamedArrayList) ois.readObject();
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	/**Writes Dataline into the file*/
	public void save()
	{
		try
		{
			saveos = new FileOutputStream(iofile);
			saveoos = new ObjectOutputStream(saveos);
			saveoos.writeObject(DataLine);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static double getDatamanagerVersion()
	{
		return DATAMANAGER_VERSION;
	}

}

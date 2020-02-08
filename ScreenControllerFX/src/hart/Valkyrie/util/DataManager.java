/**Datamanager is a basic automated way of using a NAL to read and write from a file
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

import hart.Valkyrie.SuperConductor;
import hart.Valkyrie.objects.NamedList;

public class DataManager<T> implements SuperConductor
{
	private final static double DATAMANAGER_VERSION = 1.1;

	private FileInputStream fis;
	private ObjectInputStream ois;

	private FileOutputStream saveos;
	private ObjectOutputStream saveoos;
	/** DataLine is a Public NAL that the file is copyed into */
	public NamedList<T> DataLine;

	private File iofile;

	/**
	 * Constructor for DataManager, this links the DataManager's OIS and OOS to the
	 * file
	 * 
	 * @param ifile A file object
	 * @throws IOException
	 */

	public DataManager(File file) throws IOException
	{
		iofile = file;
		iofile.createNewFile();
	}

	/**
	 * The Load method will copy the NAL from a File into the public DataLine Field
	 */

	public void load()
	{
		try
		{
			fis = new FileInputStream(iofile);
			ois = new ObjectInputStream(fis);
			DataLine = (NamedList<T>) ois.readObject();
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	/** Writes Dataline into the file */
	public void save()
	{
		try
		{
			iofile.delete();
			iofile.createNewFile();
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

	@Override
	public void deConstruct()
	{
		fis = null;
		ois = null;
		saveos = null;
		saveoos = null;
		DataLine.deConstruct();
		DataLine = null;
	}

}

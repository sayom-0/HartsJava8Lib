package hart.Valkyrie.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GenericData<T>
{
	private final static double GENERICDATA_VERSION = 1.1;

	private FileInputStream fis;
	private ObjectInputStream ois;

	private FileOutputStream saveos;
	private ObjectOutputStream saveoos;
	/**DataLine is a Public NAL that the file is copyed into*/
	public T Data;
	
	private File iofile;
	
	/**Constructor for DataManager, this links the DataManager's OIS and OOS to the file
	 * 
	 * @param ifile A file object
	 * @throws IOException 
	 */

	public GenericData(File file) throws IOException
	{
		iofile = file;
		iofile.createNewFile();
	}
	
	/**The Load method will copy the NAL from a File into the public DataLine Field*/

	public void load()
	{
		try
		{
			fis = new FileInputStream(iofile);
			ois = new ObjectInputStream(fis);
			Data = (T) ois.readObject();
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
			iofile.delete();
			iofile.createNewFile();
			saveos = new FileOutputStream(iofile);
			saveoos = new ObjectOutputStream(saveos);
			saveoos.writeObject(Data);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static double getGenericDataVersion()
	{
		return GENERICDATA_VERSION;
	}
}

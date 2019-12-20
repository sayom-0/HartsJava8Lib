package hart.Valkyrie.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataManager
{
	private final static double DATAMANAGER_VERSION = 1.0;
	
	private FileInputStream fis;
	private ObjectInputStream ois;
	
	private FileOutputStream saveos;
	private ObjectOutputStream saveoos;
	
	public NamedArrayList DataLine;
	
	public DataManager(File file)
	{
		DataLine = new NamedArrayList();
		try
		{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			DataLine = (NamedArrayList) ois.readObject();
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			saveos = new FileOutputStream(file);
			saveoos = new ObjectOutputStream(saveos);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void save()
	{
		try
		{
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

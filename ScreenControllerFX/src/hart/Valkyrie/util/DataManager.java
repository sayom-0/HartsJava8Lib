package hart.Valkyrie.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import hart.Valkyrie.objects.NamedArrayList;

public class DataManager
{
	private final static double DATAMANAGER_VERSION = 1.0;

	private FileInputStream fis;
	private ObjectInputStream ois;

	private FileOutputStream saveos;
	private ObjectOutputStream saveoos;

	public NamedArrayList DataLine;
	
	private File iofile;

	public DataManager(File file)
	{
		DataLine = new NamedArrayList();
		iofile = file;
	}

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

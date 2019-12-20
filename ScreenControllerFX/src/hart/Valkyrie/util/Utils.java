//Author: Logan Xander Hart

package hart.Valkyrie.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Utils
{
	private final static double UTILS_VERSION = 1.3;

	public static int searchArrayList(ArrayList<Object> array, Object val)
	{
		if (array.contains(val))
		{
			int x = 0;
			while (true)
			{
				if (array.get(x) == val)
				{
					return x;
				} else
				{
					x++;
				}
			}
		}

		return -1;
	}

	public static double getUtilsVersion()
	{
		return UTILS_VERSION;
	}

	public static Object read(File ifile, Object otr)
	{
		FileInputStream fis;
		ObjectInputStream ois;
		try
		{
			fis = new FileInputStream(ifile);
			ois = new ObjectInputStream(fis);
			return (Object) ois.readObject();
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void write(File ifile, Object otw)
	{
		FileOutputStream saveos = null;
		ObjectOutputStream saveoos = null;

		try
		{
			saveos = new FileOutputStream(ifile);
			saveoos = new ObjectOutputStream(saveos);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			saveoos.writeObject(otw);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

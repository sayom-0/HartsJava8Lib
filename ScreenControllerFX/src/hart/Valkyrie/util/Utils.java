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
	private final static double UTILS_VERSION = 1.4;

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
	
}

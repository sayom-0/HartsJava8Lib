//Author: Logan Xander Hart

package hart.Valkyrie.util;

import java.util.ArrayList;

public class Utils
{
	private final static double UTILS_VERSION = 1.5;

	public static int searchArrayList(ArrayList array, Object val)
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
	
	public static Object getArrayRow(int row, Object[] obj)
	{
		String output = "";
		int counter = 0;

		while (counter != obj.length)
		{
			output += obj[counter];
			counter++;
		}

		return output;
	}

	public static Object getArrayRow(int row, Object[][] obj)
	{
		String output = "";
		int counter = 0;

		while (counter != obj.length)
		{
			output += obj[row][counter];
			counter++;
		}

		return output;
	}
	
	public static Object getArrayCol(int col, Object[][] obj)
	{
		String output = "";
		int counter = 0;

		while (counter != obj.length)
		{
			output += obj[counter][col];
			counter++;
		}

		return output;
	}

	public static double getUtilsVersion()
	{
		return UTILS_VERSION;
	}

}

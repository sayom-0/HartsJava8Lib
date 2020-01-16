/** Description of MyClass 
 *
 * @author Logan Hart
 * @version V1.5-1.16.20
 */
package hart.Valkyrie.util;

import java.util.ArrayList;

public class Utils
{
	private final static double UTILS_VERSION = 1.5;

	/**
	 * searchArrayList is a simple method, it
	 * will return a integer value that is the index of where the given value was
	 * found in the ArrayList. If it could not be found it will return -1
	 * 
	 * @param array A ArrayList, type is irrelevant.
	 * @param val   Anything that extends Java.lang.Object, this is what the array
	 *              is searched for.
	 */
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

	/**getArrayRow will return a entire array row.
	 * 
	 * @param row The row to return.
	 * @param obj the Array to get a row from.
	 */
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
	/**getArrayRow will return a entire array row.
	 * 
	 * @param row The row to return.
	 * @param obj the Array to get a row from.
	 */
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
	/**getArrayCol will return a entire array collum.
	 * 
	 * @param col The row to return.
	 * @param obj the Array to get a collum from.
	 */
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

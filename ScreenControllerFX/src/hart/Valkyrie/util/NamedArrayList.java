//Author: Logan Xander Hart

package hart.Valkyrie.util;

import java.util.ArrayList;

public class NamedArrayList
{
	private ArrayList<Object> NAL;
	private ArrayList<Object> DAL;

	private final static double UTILS_VERSION = 1.0;

	public void add(String name, Object data)
	{
		NAL.add(name);
		DAL.add(data);
	}

	public Object get(String name)
	{
		return DAL.get(hart.Valkyrie.util.Utils.searchArrayList(NAL, name));
	}

	public void set(String name, Object data)
	{
		DAL.set(hart.Valkyrie.util.Utils.searchArrayList(NAL, name), data);
	}

	public void remove(String name)
	{
		DAL.remove(hart.Valkyrie.util.Utils.searchArrayList(NAL, name));
		NAL.remove(hart.Valkyrie.util.Utils.searchArrayList(NAL, name));
	}

	public static double getUtilsVersion()
	{
		return UTILS_VERSION;
	}

}

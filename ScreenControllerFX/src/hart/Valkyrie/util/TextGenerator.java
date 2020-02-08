/** Simple random text generate. Pass a string array of names, then call the name() method to get a random name.
 *
 * @author Logan Hart
 * @version V1.1
 */
package hart.Valkyrie.util;

import java.util.Random;

import hart.Valkyrie.SuperConductor;

public class TextGenerator implements SuperConductor
{
	private String[] names;
	private Random r;

	/**
	 * Constructor to get names from
	 * 
	 * @param x String array to call random names from
	 */

	public TextGenerator(String[] x)
	{
		names = x;
		r = new Random();
	}

	/**
	 * 
	 * @param length How long should the name be
	 * @return returns a random name the length of the int you passed
	 */
	public String name(int length)
	{
		String o = "";
		for (int loop = 0; length > loop; loop++)
		{
			o += names[(int) (r.nextInt(names.length))] + " ";
		}

		return o;
	}

	@Override
	public void deConstruct()
	{
		names = null;
		r = null;
	}
}

package hart.Valkyrie.util;

import java.util.Random;

public class TextGenerator
{
	private String[] names;
	private Random r;

	public TextGenerator(String[] x)
	{
		names = x;
		r = new Random();
	}

	public String name(int length)
	{
		String o = "";
		for (int loop = 0; length > loop; loop++)
		{
			o += names[(int) (r.nextInt(names.length))];
		}

		return o;
	}
}

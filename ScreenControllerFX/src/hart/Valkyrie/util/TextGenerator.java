package hart.Valkyrie.util;

public class TextGenerator
{
	String[] names;

	public TextGenerator(String[] x)
	{
		names = x;
	}

	public String name(int length)
	{
		String o = "";
		for (int loop = 0; length > loop; loop++)
		{
			o += names[(int) ((Math.random() + 1) * names.length)];
		}

		return o;
	}
}

//Author: Logan Xander Hart

package hart.Valkyrie.SCFX;

import java.util.ArrayList;

import hart.Valkyrie.exceptions.IllegalDimensionsException;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScreenControllerFX
{
	private static final double SCFX_VERSION = 1.4;

	private double width;
	private double height;

	private ArrayList<String> fontsindex = new ArrayList<String>();
	private ArrayList<String> otextindex = new ArrayList<String>();

	private ArrayList<Font> fonts = new ArrayList<Font>();
	private ArrayList<Text> otext = new ArrayList<Text>();

	public ScreenControllerFX()
	{
		super();
	}

	public ScreenControllerFX(double width, double height) throws IllegalDimensionsException
	{
		super();
		if (width > 0)
		{
			this.width = width;
		} else
		{
			throw new IllegalDimensionsException("Invalid Width, must be greater then 0");
		}

		if (height > 0)
		{
			this.height = height;
		} else
		{
			throw new IllegalDimensionsException("Invalid Height, must be greater then 0");
		}
	}

	public Text getText(String si)
	{
		int x = 0;
		if (otextindex.contains(si))
			;
		{
			while (!(otextindex.get(x) == si))
			{
				x++;
			}
			return otext.get(x);
		}
	}

	public void makeText(String fname, Text itext, String fn)
	{
		otextindex.add(fname);

		itext.setFont(getFont(fn));

		otext.add(itext);
	}

	public Font getFont(String si)
	{
		int x = 0;
		if (fontsindex.contains(si))
			;
		{
			while (!(fontsindex.get(x) == si))
			{
				x++;
			}
			return fonts.get(x);
		}
	}

	public void makeFont(String fname, Font ifont)
	{
		fontsindex.add(fname);
		fonts.add(ifont);
	}

	public void setRes(String si, double i)
	{
		if (si.equalsIgnoreCase("width"))
		{
			this.width = i;
		} else if (si.equalsIgnoreCase("height"))
		{
			this.height = i;
		}
	}

	public void setRes(double width, double height)
	{
		this.width = width;
		this.height = height;
	}

	public double getRes(String si)
	{
		if (si.equalsIgnoreCase("width"))
		{
			return this.width;
		} else if (si.equalsIgnoreCase("height"))
		{
			return this.height;
		} else
		{
			return 0;
		}
	}

	public static double getScfxVersion()
	{
		return SCFX_VERSION;
	}

	public double centerX(Object t)
	{
		return (this.width / 2) - (((Node) t).getLayoutBounds().getWidth() / 2);
	}

	public double centerY(Object t)
	{
		return (this.height / 2) - ((Node) t).getLayoutBounds().getHeight();
	}
}

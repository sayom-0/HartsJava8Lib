//Author: Logan Xander Hart

package hart.Valkyrie.SCFX;

import hart.Valkyrie.exceptions.IllegalDimensionsException;
import hart.Valkyrie.util.NamedArrayList;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScreenControllerFX 
{
	private static final double SCFX_VERSION = 1.6;

	private double width;
	private double height;

	private NamedArrayList texts = new NamedArrayList();
	private NamedArrayList fonts = new NamedArrayList();

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
		return (Text) texts.get(si);
	}

	public void makeText(String fname, Text itext, String fn)
	{
		itext.setFont(getFont(fn));
		texts.add(fname, itext);
	}

	public void makeText(String fname, Text itext)
	{
		texts.add(fname, itext);
	}
	
	public void replaceText(String fname, Text itext)
	{
		texts.set(fname, itext);
	}

	public Font getFont(String si)
	{
		return (Font) fonts.get(si);
	}
	
	public void replaceFont(String fname, Font ifont)
	{
		fonts.set(fname, ifont);
	}

	public void makeFont(String fname, Font ifont)
	{
		fonts.add(fname, ifont);
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

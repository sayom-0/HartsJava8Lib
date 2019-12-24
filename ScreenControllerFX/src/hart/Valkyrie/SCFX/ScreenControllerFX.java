//Author: Logan Xander Hart

package hart.Valkyrie.SCFX;

import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.IllegalDimensionsException;
import hart.Valkyrie.exceptions.InvalidMoudleException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.objects.EventButtonManager;
import hart.Valkyrie.objects.NamedArrayList;
import javafx.scene.Node;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScreenControllerFX
{
	private static final double SCFX_VERSION = 1.7;

	private double width;
	private double height;

	private NamedArrayList texts;
	private NamedArrayList fonts;

	private NamedArrayList modules;

	private void initd()
	{
		texts = new NamedArrayList();
		fonts = new NamedArrayList();
		modules = new NamedArrayList();
	}

	public ScreenControllerFX()
	{
		super();
		initd();
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
		initd();
	}

	public NamedArrayList exportFonts()
	{
		return fonts;
	}

	public void importFonts(NamedArrayList ifonts)
	{
		fonts = ifonts;
	}
	
	public NamedArrayList exportTexts()
	{
		return texts;
	}
	
	public void importTexts(NamedArrayList itexts)
	{
		texts = itexts;
	}

	public void loadModule(String moduleToLoad) throws InvalidMoudleException, DuplicateNameException
	{
		switch (moduleToLoad)
		{
		case "EventButtonManager":
			modules.add("EventButtonManager", new EventButtonManager());
			break;

		default:
			throw new InvalidMoudleException("Invalid Module Name");
		}
	}

	public Object interactModule(String module) throws NonExistantDataException
	{
		return modules.get(module);
	}

	public Text getText(String si) throws NonExistantDataException
	{
		return (Text) texts.get(si);
	}

	public void makeText(String fname, Text itext, String fn) throws DuplicateNameException, NonExistantDataException
	{
		itext.setFont(getFont(fn));
		texts.add(fname, itext);
	}

	public void makeText(String fname, Text itext) throws DuplicateNameException
	{
		texts.add(fname, itext);
	}

	public void replaceText(String fname, Text itext) throws NonExistantDataException
	{
		texts.set(fname, itext);
	}

	public Font getFont(String si) throws NonExistantDataException
	{
		return (Font) fonts.get(si);
	}

	public void replaceFont(String fname, Font ifont) throws NonExistantDataException
	{
		fonts.set(fname, ifont);
	}

	public void makeFont(String fname, Font ifont) throws DuplicateNameException
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

	public double centerX(Node t)
	{
		System.out.println("CenterX Method is marked for review / deletion, this method may not be functional in newer versions of SCFX");
		return (this.width / 2) - (t.getLayoutBounds().getWidth() / 2);
	}

	public double centerY(Node t)
	{
		System.out.println("CenterY Method is marked for review / deletion, this method may not be functional in newer versions of SCFX");
		return (this.height / 2) - t.getLayoutBounds().getHeight();
	}
}

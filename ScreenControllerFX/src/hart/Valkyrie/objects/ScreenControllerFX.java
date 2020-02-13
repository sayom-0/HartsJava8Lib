/**
 * @author Logan Hart
 * @version V1.9
 */
package hart.Valkyrie.objects;

import hart.Valkyrie.SuperConductor;
import hart.Valkyrie.exceptions.DuplicateNameException;
import hart.Valkyrie.exceptions.IllegalDimensionsException;
import hart.Valkyrie.exceptions.NonExistantDataException;
import hart.Valkyrie.objects.NamedLists.NamedArrayList;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * ScreenControllerFX, or SCFX for short is a superclass and was the first major
 * addition to this library, its goal is to make storing basic javafx data
 * simpler and easy to manage, it utilizes multiple NAL's as well as module
 * tie-in's to other classes in the library in order to manage Text, Fonts,
 * Buttons, Nodes, EventHandlers, Resolutions, and much, much more.
 */
public class ScreenControllerFX implements SuperConductor
{
	private static final double SCFX_VERSION = 1.9;

	private double width;
	private double height;

	private NamedArrayList<Text> texts;
	private NamedArrayList<Font> fonts;

	private void initd()
	{
		texts = new NamedArrayList<>();
		fonts = new NamedArrayList<>();
	}

	/** No-Args Constructor */
	public ScreenControllerFX()
	{
		super();
		initd();
	}

	/**
	 * @param width  Width of Screen
	 * @param height of Screen
	 * @throws IllegalDimensionsException 
	 */
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

	/** @return returns fonts NAL */
	public NamedArrayList<Font> exportFonts()
	{
		return fonts;
	}

	/** @param ifonts fonts NAL to load */
	public void importFonts(NamedArrayList<Font> ifonts)
	{
		fonts = ifonts;
	}

	/** @return Returns Text NAL */
	public NamedArrayList<Text> exportTexts()
	{
		return texts;
	}

	/** @param itexts Texts NAL to load */
	public void importTexts(NamedArrayList<Text> itexts)
	{
		texts = itexts;
	}

	/** @param si Name of text to return 
	 * @throws NonExistantDataException 
	 * @return Text that was just made*/
	public Text getText(String si) throws NonExistantDataException
	{
		return texts.get(si);
	}

	/**
	 * @param fname name of new text
	 * @param itext new text object
	 * @throws DuplicateNameException 
	 * @throws NonExistantDataException 
	 * @return Text that was just made
	 */
	public Text makeText(String fname, Text itext) throws DuplicateNameException, NonExistantDataException
	{
		texts.add(fname, itext);
		return texts.get(fname);
	}

	/**
	 * @param fname name of new text
	 * @param itext new text object
	 * @param fn    Font for new Text
	 * @return Text that was just made
	 * @throws DuplicateNameException 
	 * @throws NonExistantDataException 
	 */
	public Text makeText(String fname, Text itext, Font fn) throws DuplicateNameException, NonExistantDataException 
	{
		itext.setFont(fn);
		texts.add(fname, itext);
		return texts.get(fname);
	}

	/**
	 * @param fname name of new text
	 * @param itext new text object
	 * @param fn    String name of Font for new Text
	 * @return Text that was just made
	 * @throws DuplicateNameException 
	 * @throws NonExistantDataException 
	 */
	public Text makeText(String fname, Text itext, String fn) throws DuplicateNameException, NonExistantDataException
	{
		itext.setFont(getFont(fn));
		texts.add(fname, itext);
		return texts.get(fname);
	}

	/**
	 * @return Returns a text object built with SCFX syntax
	 * @param text Text Object to be modifyed
	 * @param font Name of font
	 * @throws NonExistantDataException
	 * @return Text that you made
	 */
	public Text buildText(Text text, String font) throws NonExistantDataException
	{
		text.setFont(fonts.get(font));
		return text;
	}

	/**
	 * @param fname Name of text to replace
	 * @param itext New Text Object
	 * @throws NonExistantDataException 
	 */
	public void replaceText(String fname, Text itext) throws NonExistantDataException
	{
		texts.set(fname, itext);
	}

	/** @param si Name of font to return 
	 * @throws NonExistantDataException 
	 * @return Font that you searched for*/

	public Font getFont(String si) throws NonExistantDataException
	{
		return (Font) fonts.get(si);
	}

	/**
	 * @param fname Name of font to replace
	 * @param ifont New Font Object
	 * @throws NonExistantDataException 
	 */
	public void replaceFont(String fname, Font ifont) throws NonExistantDataException
	{
		fonts.set(fname, ifont);
	}

	/**
	 * @param fname Name of new Font
	 * @param ifont Font object to pass
	 * @return 
	 * @throws DuplicateNameException 
	 * @throws NonExistantDataException 
	 * @return Font that you made
	 */
	public Font makeFont(String fname, Font ifont) throws DuplicateNameException, NonExistantDataException
	{
		fonts.add(fname, ifont);
		return fonts.get(fname);
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

	@Override
	public void deConstruct()
	{
		texts.deConstruct();
		texts = null;
		fonts.deConstruct();
		fonts = null;
		width = (Double) null;
		height = (Double) null;
	}
}

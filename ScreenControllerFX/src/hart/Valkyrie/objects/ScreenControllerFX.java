/**
 * @author Logan Hart
 * @version V2.2
 */
package hart.Valkyrie.objects;

import java.util.HashMap;
import java.util.Map;
import hart.Valkyrie.SuperConductor;
import hart.Valkyrie.exceptions.IllegalDimensionsException;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * ScreenControllerFX, or SCFX for short is a superclass and was the first major
 * addition to this library, its goal is to make storing basic javafx data
 * simpler and easy to manage, it utilizes multiple HashMaps's as well as module
 * tie-in's to other classes in the library in order to manage Text, Fonts,
 * Buttons, Nodes, EventHandlers, Resolutions, and much, much more.
 */

public class ScreenControllerFX implements SuperConductor
{

	private double width;
	private double height;

	private Map<String, Text> texts;
	private Map<String, Font> fonts;

	private void initd()
	{
		texts = new HashMap<>();
		fonts = new HashMap<>();
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
	public Map<String, Font> exportFonts()
	{
		return fonts;
	}

	/** @param ifonts fonts NAL to load */
	public void importFonts(Map<String, Font> ifonts)
	{
		fonts = ifonts;
	}

	/** @return Returns Text NAL */
	public Map<String, Text> exportTexts()
	{
		return texts;
	}

	/** @param itexts Texts NAL to load */
	public void importTexts(Map<String, Text> itexts)
	{
		texts = itexts;
	}

	/**
	 * @param si Name of text to return
	 * @return Text that was just made
	 */
	public Text getText(String si)
	{
		return texts.get(si);
	}

	/**
	 * @param fname name of new text
	 * @param itext new text object
	 * @return Text that was just made
	 */
	public Text setText(String fname, Text itext)
	{
		texts.put(fname, itext);
		return texts.get(fname);
	}

	/**
	 * @param fname name of new text
	 * @param itext new text object
	 * @param fn    Font for new Text
	 * @return Text that was just made
	 */
	public Text setText(String fname, Text itext, Font fn)
	{
		itext.setFont(fn);
		texts.put(fname, itext);
		return texts.get(fname);
	}

	/**
	 * @param fname name of new text
	 * @param itext new text object
	 * @param fn    String name of Font for new Text
	 * @return Text that was just made
	 */
	public Text setText(String fname, Text itext, String fn)
	{
		itext.setFont(getFont(fn));
		texts.put(fname, itext);
		return texts.get(fname);
	}

	/**
	 * @return Returns a text object built with SCFX syntax
	 * @param text Text Object to be modified
	 * @param font Name of font
	 * @return Text that you made
	 */
	public Text buildText(Text text, String font)
	{
		text.setFont(fonts.get(font));
		return text;
	}
	
	/**
	 * @return Returns a text object built with SCFX syntax
	 * @param text Text Object to be modified
	 * @param font Font object to apply to text
	 * @return Text that you made
	 */
	public static Text buildText(Text text, Font font)
	{
		text.setFont(font);
		return text;
	}

	/**
	 * @param si Name of font to return
	 * @return Font that you searched for
	 */

	public Font getFont(String si)
	{
		return (Font) fonts.get(si);
	}

	/**
	 * @param fname Name of new Font
	 * @param ifont Font object to pass
	 * @return
	 * @return Font that you made
	 */
	public Font setFont(String fname, Font ifont)
	{
		fonts.put(fname, ifont);
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
	
	@Override
	public void deConstruct()
	{
		texts = null;
		fonts = null;
		width = (Double) null;
		height = (Double) null;
	}
}

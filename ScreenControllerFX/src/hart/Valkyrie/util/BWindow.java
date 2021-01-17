/** Simple drop in replacement for JavaFX application class, since it only allows for one window to be open, also adds in SCFX and EBM fields to use, they are not instantiated.
 *
 * @author Logan Hart
 * @version V1.1
 */
package hart.Valkyrie.util;

import java.util.ArrayList;

import hart.Valkyrie.objects.ScreenControllerFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BWindow extends Application
{
	protected ScreenControllerFX SCFX;
	private ArrayList<BWindow> windows;
	protected Scene scene;
	protected Stage stage;
	private boolean open;

	public BWindow()
	{
		windows = new ArrayList<>();
		stage = new Stage();
	}

	/**
	 * Replacement for launch();
	 * 
	 * @throws Exception
	 */

	public void window() throws Exception
	{
		open = true;
		start(stage);
	}

	/** Safely close this window and all of its sub windows */
	public void closeAll()
	{
		for (int x = 0; x != windows.size(); x++)
			windows.get(x).safeClose();
		this.safeClose();
	}

	/** Check if window is already closed */
	public void safeClose()
	{
		if (open)
			close();
	}

	/** Close the window (Unless you know what you're doing use safeClose() ) */
	public void close()
	{
		open = false;
		stage.close();
	}

	/** Check if stage is shown */
	public boolean isOpen()
	{
		return open;
	}

	/** Add a sub window, sub windows close if the parent is closed */
	public void indexSubBW(BWindow bw)
	{
		windows.add(bw);
	}
}

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
	
	/**This method must be run inside of the class that extends BW in order for it to work correctly*/
	protected void initd()
	{
		windows = new ArrayList<>();
		stage = new Stage();
	}

	/** Replacement for launch(); */

	public void window() throws Exception
	{
		open = true;
		start(stage);
	}
	
	public void closeAll()
	{
		for(int x = 0; x != windows.size(); x++)
		{
			windows.get(x).safeClose();
		}
		this.safeClose();
	}

	/**Check if window is already closed*/
	public void safeClose()
	{
		if (open)
		{
			close();
		} else
		{
		}
	}

	/** Close the window */
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
	
	public void indexSubBW(BWindow bw)
	{
		windows.add(bw);
	}
}

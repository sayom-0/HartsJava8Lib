/** Simple drop in replacement for JavaFX application class, since it only allows for one window to be open, also adds in SCFX and EBM fields to use, they are not instantiated.
 *
 * @author Logan Hart
 * @version V1.1
 */
package hart.Valkyrie.util;

import hart.Valkyrie.objects.ScreenControllerFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BWindow extends Application
{
	protected ScreenControllerFX SCFX;
	protected Scene scene;
	protected Stage stage;
	private boolean open;

	/** Replacement for launch(); */

	public void window() throws Exception
	{
		stage = new Stage();
		open = true;
		start(stage);
	}

	/**Check if window is already closed*/
	public void safeClose()
	{
		if (open)
		{
			close();
			System.out.println(getClass() + " : Closed");
		} else
		{
			System.out.println(getClass() + " : Already closed");
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
}

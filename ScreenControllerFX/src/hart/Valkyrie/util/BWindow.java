/** Simple drop in replacement for JavaFX application class, since it only allows for one window to be open, also adds in SCFX and EBM fields to use, they are not instantiated.
 *
 * @author Logan Hart
 * @version V1.1
 */
package hart.Valkyrie.util;

import hart.Valkyrie.SCFX.ScreenControllerFX;
import hart.Valkyrie.objects.EventButtonManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BWindow extends Application
{
	protected ScreenControllerFX SCFX;
	protected EventButtonManager ebm;
	protected Scene scene;
	
	/**Replacement for launch();*/

	public void window() throws Exception
	{
		start(new Stage());
	}
}

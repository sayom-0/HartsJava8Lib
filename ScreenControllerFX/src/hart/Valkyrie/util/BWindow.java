package hart.Valkyrie.util;

import hart.Valkyrie.SCFX.ScreenControllerFX;
import hart.Valkyrie.objects.EventButtonManager;
import javafx.application.Application;
import javafx.stage.Stage;

public abstract class BWindow extends Application
{
	protected ScreenControllerFX SCFX;
	protected EventButtonManager ebm;
	
	public void window() throws Exception
	{
		start(new Stage());
	}
}

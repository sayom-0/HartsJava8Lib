package hart.Valkyrie.util;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class BWindow extends Application
{
	public void window() throws Exception
	{
		start(new Stage());
	}
}

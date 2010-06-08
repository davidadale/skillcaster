package resume.client;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceManager;
import resume.client.gin.ResumeGinjector;
import resume.client.presenter.AppPresenter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Resume implements EntryPoint {
	
	private final ResumeGinjector injector = GWT.create( ResumeGinjector.class );

	public static EventBus EVENT_BUS;

	public void onModuleLoad() {

			EVENT_BUS = injector.getEventBus();

			PlaceManager manager = injector.getPlaceManager();
			
			//FramePresenter frame = injector.getFramePresenter();
			//frame.bind();
			//frame.go( RootLayoutPanel.get() );
			AppPresenter app = injector.getAppPresenter();
			app.bind();
			app.go( RootLayoutPanel.get() );
			
			manager.fireCurrentPlace();
	}
}

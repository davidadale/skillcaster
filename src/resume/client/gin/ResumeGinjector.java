package resume.client.gin;

import net.customware.gwt.dispatch.client.gin.ClientDispatchModule;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceManager;
import resume.client.presenter.AppPresenter;
import resume.client.presenter.FramePresenter;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;


@GinModules({ ClientDispatchModule.class, ResumeClientModule.class })
public interface ResumeGinjector extends Ginjector {
	FramePresenter getFramePresenter();
	AppPresenter getAppPresenter();
	PlaceManager getPlaceManager();
	EventBus getEventBus();
}

package resume.client.presenter;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.event.Message;
import resume.shared.event.MessageHandler;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class FramePresenter extends WidgetPresenter<FramePresenter.Display> {
	
	HasWidgets container;
	
	public static Place PLACE = new Place("Home");
	
	@Inject
	public FramePresenter(Display display, EventBus eventBus,
			UnauthorizedPresenter unauthorizedPresenter,
			MyProfilePresenter myProfilePresenter ) {
		super(display, eventBus);
	}

	public interface Display extends WidgetDisplay{
		public void showView(WidgetDisplay display);
		public void closeView(WidgetDisplay display);
		public void show(Message message);
	}
	
	public void go(HasWidgets container){
		this.container = container;
		container.add( display.asWidget() );
	}
	
	@Override
	public Place getPlace() {
		return PLACE;
	}

	
	@Override
	protected void onBind() {
		
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		
	}

	@Override
	protected void onUnbind() {
		eventBus.addHandler(Message.TYPE, new MessageHandler() {
			public void handle(Message msg) {
				display.show( msg );
			}
		});
	}

	public void refreshDisplay() {
		
	}

	public void revealDisplay() {
		
	}
	
}

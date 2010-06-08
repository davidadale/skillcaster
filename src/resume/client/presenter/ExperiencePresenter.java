package resume.client.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.data.Experience;
import resume.shared.event.CancelEvent;
import resume.shared.event.ExperienceSavedEvent;
import resume.shared.rpc.DispatchCallback;
import resume.shared.rpc.SaveExperience;
import resume.shared.rpc.SaveExperienceResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;

public class ExperiencePresenter extends WidgetPresenter<ExperiencePresenter.Display> {

	DispatchAsync dispatcher;
	Experience experience;
	
	@Inject
	public ExperiencePresenter(Display display, EventBus eventBus, DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
	}

	public interface Display extends WidgetDisplay{
		public HasClickHandlers getSaveButton();
		public HasClickHandlers getCancelButton();
		public void setExperience(Experience experience);
		public void commit();
	}

	@Override
	public Place getPlace() {
		return null;
	}

	@Override
	protected void onBind() {
		
		display.getSaveButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.commit();
				dispatcher.execute(new SaveExperience( experience ),  new DispatchCallback<SaveExperienceResult>() {
					public void onSuccess(SaveExperienceResult result) {
						eventBus.fireEvent( new ExperienceSavedEvent( result.getExperience() ) );
						eventBus.fireEvent( new CancelEvent( ExperiencePresenter.this ) ); 
					};
				}); 
			}
		});
		
		display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				eventBus.fireEvent( new CancelEvent(ExperiencePresenter.this) );
			}
		});
	}
	
	public void setExperience(Experience exp){
		this.experience = exp;
		display.setExperience( exp );
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		
	}

	@Override
	protected void onUnbind() {
		
	}

	public void refreshDisplay() {
		
	}

	public void revealDisplay() {
		
	}
	
}

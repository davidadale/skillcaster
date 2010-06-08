package resume.client.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.data.Education;
import resume.shared.event.CancelEvent;
import resume.shared.rpc.DispatchCallback;
import resume.shared.rpc.EducationSavedEvent;
import resume.shared.rpc.SaveEducation;
import resume.shared.rpc.SaveEducationResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;

public class EducationPresenter extends WidgetPresenter<EducationPresenter.Display> {

	DispatchAsync dispatcher;
	Education education;
	
	@Inject
	public EducationPresenter(Display display, EventBus eventBus, DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
	}

	public interface Display extends WidgetDisplay{
		
		void setEducation(Education education);
		void commit();
		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();
		
	}
	
	public void setEducation(Education edu){
		this.education = edu;
		display.setEducation( edu );
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onBind() {
		display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				eventBus.fireEvent( new CancelEvent(EducationPresenter.this ) );
			}
		});
		
		display.getSaveButton().addClickHandler( new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.commit();
				
				dispatcher.execute(new SaveEducation(education), new DispatchCallback<SaveEducationResult>() {
					public void onSuccess(SaveEducationResult result) {
						eventBus.fireEvent(new EducationSavedEvent ( result.getEducation() ) );
						eventBus.fireEvent( new CancelEvent( EducationPresenter.this ) );
					}
				});
				
			}
		});
		
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub
		
	}

	public void refreshDisplay() {
		// TODO Auto-generated method stub
		
	}

	public void revealDisplay() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}

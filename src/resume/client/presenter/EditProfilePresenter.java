package resume.client.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.data.Profile;
import resume.shared.event.CancelEvent;
import resume.shared.event.ProfileLoadedEvent;
import resume.shared.event.ProfileLoadedEventHandler;
import resume.shared.event.ProfileSavedEvent;
import resume.shared.rpc.DispatchCallback;
import resume.shared.rpc.SaveProfile;
import resume.shared.rpc.SaveProfileResult;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;



public class EditProfilePresenter extends WidgetPresenter<EditProfilePresenter.Display> {
	
	DispatchAsync dispatcher;
	
	Profile profile;
	
	@Inject
	public EditProfilePresenter( Display display,
								 DispatchAsync dispatcher,
			                     EventBus eventBus) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
	}

	public interface Display extends WidgetDisplay{
		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();
		void setProfile(Profile profile);
		void commit();
	}
	
	public void setProfile(Profile profile){
		this.profile = profile;
		display.setProfile( profile );
	}

	@Override
	public Place getPlace() {
		return null;
	}

	@Override
	protected void onBind() {
				
		eventBus.addHandler( ProfileLoadedEvent.TYPE, new ProfileLoadedEventHandler() {
			public void onProfileLoaded(ProfileLoadedEvent event) {
				profile = event.getProfile();
				display.setProfile( event.getProfile() );
			}
		});
		
		
		getDisplay().getSaveButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				display.commit(); // put the data back on the model.
				
				dispatcher.execute(new SaveProfile( profile ), new DispatchCallback<SaveProfileResult>() {
					@Override
					public void onSuccess(SaveProfileResult result) {
						eventBus.fireEvent( new ProfileSavedEvent( profile ) );
						eventBus.fireEvent( new CancelEvent(EditProfilePresenter.this) );
					}
				});				
			
			}
		});
		
		display.getCancelButton().addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) {
				eventBus.fireEvent( new CancelEvent( EditProfilePresenter.this ) );
			}
		});
		
	}
		
	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onUnbind() {
		
		
	}

	public void refreshDisplay() {
		Log.debug("Refresh Display");
		
	}

	public void revealDisplay() {
		Log.debug("Reveal Display");
		
	}
	
}

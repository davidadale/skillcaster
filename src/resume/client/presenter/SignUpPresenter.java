package resume.client.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.data.Profile;
import resume.shared.data.User;
import resume.shared.event.SignupCompleteEvent;
import resume.shared.rpc.DispatchCallback;
import resume.shared.rpc.Signup;
import resume.shared.rpc.SignupResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;

public class SignUpPresenter extends WidgetPresenter<SignUpPresenter.Display> {

	public static Place PLACE = new Place("sign-up");
	
	public interface Display extends WidgetDisplay {
		void setProfile(Profile profile);
		void setUser(User user);
		void commit();

		HasClickHandlers getSignUpButon();
	}

	DispatchAsync dispatcher;
	Profile profile;
	User user;
	
	@Inject
	public SignUpPresenter(Display display, EventBus eventBus,
			DispatchAsync dispatcher) {
		
		super(display, eventBus);
		this.dispatcher = dispatcher;
		display.setProfile( profile = new Profile() );
		display.setUser( user = new User() );
		
	}

	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onBind() {
		display.getSignUpButon().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.commit();
				dispatcher.execute(new Signup( profile, user ), new DispatchCallback<SignupResult>() {
					public void onSuccess(SignupResult result) {
						eventBus.fireEvent(new SignupCompleteEvent( result.getToken() ) );
					};
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

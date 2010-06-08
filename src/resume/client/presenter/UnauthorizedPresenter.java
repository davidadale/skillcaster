package resume.client.presenter;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.event.Message;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;

public class UnauthorizedPresenter extends WidgetPresenter<UnauthorizedPresenter.Display> {

	public static Place PLACE = new Place("unauthorized");
	
	SignUpPresenter signUp;
	LoginPresenter loginPresenter;
	SignUpPresenter signupPresenter;

	public interface Display extends WidgetDisplay{
		void setLoginPanel(LoginPresenter.Display view);
		void setSignUpView(SignUpPresenter.Display view);
		void activateLoginPanel();
		void show( Message msg );
		
	}

	@Inject
	public UnauthorizedPresenter(Display display, EventBus eventBus,
			LoginPresenter loginPresenter, SignUpPresenter signupPresenter) {
		
		super(display, eventBus);
		this.loginPresenter = loginPresenter;
		this.signupPresenter = signupPresenter;
		getDisplay().setLoginPanel( loginPresenter.getDisplay() );
		getDisplay().setSignUpView( signupPresenter.getDisplay() );
		getDisplay().activateLoginPanel();
	
		
	}	
	
	@Override
	public Place getPlace() {
		return PLACE;
	}

	@Override
	protected void onBind() {
		loginPresenter.bind();
		signupPresenter.bind();
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		// TODO Auto-generated method stub
		Log.info("On Place Request");
	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub
		Log.info("On Un Bind");
	}

	public void refreshDisplay() {
		// TODO Auto-generated method stub
		Log.info("Refresh Display");
	}

	public void revealDisplay() {
		// TODO Auto-generated method stub
		Log.info("Reveal Display");
	}	
	
	
}

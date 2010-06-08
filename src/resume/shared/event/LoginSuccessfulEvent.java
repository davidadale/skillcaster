package resume.shared.event;

import resume.shared.data.SecurityToken;

import com.google.gwt.event.shared.GwtEvent;

public class LoginSuccessfulEvent extends GwtEvent<LoginSuccessfulEventHandler> {

	public static Type<LoginSuccessfulEventHandler> TYPE = 
		new Type<LoginSuccessfulEventHandler>();
	
	SecurityToken token;
	
	public LoginSuccessfulEvent(SecurityToken token){
		this.token = token;
	}
	
	@Override
	protected void dispatch(LoginSuccessfulEventHandler handler) {
		handler.onLoginSuccessful( this );		
	}

	@Override
	public GwtEvent.Type<LoginSuccessfulEventHandler> getAssociatedType() {
		return TYPE;
	}

	public SecurityToken getToken() {
		return token;
	}

	
	
}

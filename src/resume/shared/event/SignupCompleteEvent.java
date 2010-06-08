package resume.shared.event;

import resume.shared.data.SecurityToken;

import com.google.gwt.event.shared.GwtEvent;

public class SignupCompleteEvent extends GwtEvent<SignupCompleteEventHandler>{

	
	public static Type<SignupCompleteEventHandler> TYPE = 
		new Type<SignupCompleteEventHandler>();
	
	SecurityToken token;
	
	public SignupCompleteEvent(SecurityToken token) {
		super();
		this.token = token;
	}

	public SecurityToken getToken() {
		return token;
	}

	@Override
	protected void dispatch(SignupCompleteEventHandler handler) {
		handler.onSignupComlete( this );
	}

	@Override
	public Type<SignupCompleteEventHandler> getAssociatedType() {
		return TYPE;
	}

}

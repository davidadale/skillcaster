package resume.shared.event;

import resume.shared.data.Profile;

import com.google.gwt.event.shared.GwtEvent;

public class ProfileUpdateEvent extends GwtEvent<ProfileUpdateEventHandler> {
	
	public static Type<ProfileUpdateEventHandler> TYPE = new Type<ProfileUpdateEventHandler>();

	Profile profile;
	
	public ProfileUpdateEvent(Profile profile){
		this.profile = profile;
	}
	
	@Override
	protected void dispatch(ProfileUpdateEventHandler handler) {
		handler.profileUpdated( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ProfileUpdateEventHandler> getAssociatedType() {
		return TYPE;
	}

	public Profile getProfile() {
		return profile;
	}
	
}

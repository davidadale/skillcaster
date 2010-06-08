package resume.shared.event;

import resume.shared.data.Profile;

import com.google.gwt.event.shared.GwtEvent;

public class ProfileSavedEvent extends GwtEvent<ProfileSavedEventHandler> {
	
	public static Type<ProfileSavedEventHandler> TYPE = new Type<ProfileSavedEventHandler>();
	
	Profile profile;
	
	public ProfileSavedEvent(Profile profile){
		this.profile = profile;
	}

	@Override
	protected void dispatch(ProfileSavedEventHandler handler) {
		handler.saveProfile( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ProfileSavedEventHandler> getAssociatedType() {
		return TYPE;
	}

	public Profile getProfile() {
		return profile;
	}

	
	
}

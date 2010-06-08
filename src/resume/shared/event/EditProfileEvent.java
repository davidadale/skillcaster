package resume.shared.event;

import resume.shared.data.Profile;

import com.google.gwt.event.shared.GwtEvent;

public class EditProfileEvent extends GwtEvent<EditProfileEventHandler> {

	public static Type<EditProfileEventHandler> TYPE = new Type<EditProfileEventHandler>();

	Profile profile;
	
	public EditProfileEvent(Profile profile) {
		super();
		this.profile = profile;
	}

	public Profile getProfile() {
		return profile;
	}

	@Override
	protected void dispatch(EditProfileEventHandler handler) {
		handler.editProfile( this );
	}

	@Override
	public GwtEvent.Type<EditProfileEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	
}

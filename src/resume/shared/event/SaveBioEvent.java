package resume.shared.event;

import resume.shared.data.Bio;

import com.google.gwt.event.shared.GwtEvent;

public class SaveBioEvent extends GwtEvent<SaveBioEventHandler> {

	public static Type<SaveBioEventHandler> TYPE = new Type<SaveBioEventHandler>();
	
	
	private Bio bio;
	
	public SaveBioEvent(Bio bio) {
		super();
		this.bio = bio;
	}

	public Bio getBio() {
		return bio;
	}

	@Override
	protected void dispatch(SaveBioEventHandler handler) {
		handler.saveBio( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SaveBioEventHandler> getAssociatedType() {
		return TYPE;
	}

}

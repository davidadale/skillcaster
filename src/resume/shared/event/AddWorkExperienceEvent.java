package resume.shared.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddWorkExperienceEvent extends GwtEvent<AddWorkExperienceEventHandler> {
	
	public static Type<AddWorkExperienceEventHandler> TYPE = new Type<AddWorkExperienceEventHandler>();
	
	@Override
	protected void dispatch(AddWorkExperienceEventHandler handler) {
		handler.addWorkExperience( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddWorkExperienceEventHandler> getAssociatedType() {
		return TYPE;
	}

}

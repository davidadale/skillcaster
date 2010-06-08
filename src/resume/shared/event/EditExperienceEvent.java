package resume.shared.event;

import resume.shared.data.Experience;

import com.google.gwt.event.shared.GwtEvent;

public class EditExperienceEvent extends GwtEvent<EditExperienceEventHandler> {

	public static Type<EditExperienceEventHandler> TYPE = new Type<EditExperienceEventHandler>();
	
	Experience experience;
	
	public EditExperienceEvent(Experience experience) {
		super();
		this.experience = experience;
	}

	@Override
	protected void dispatch(EditExperienceEventHandler handler) {
		handler.editExperience( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<EditExperienceEventHandler> getAssociatedType() {
		return TYPE;
	}

	public Experience getExperience() {
		return experience;
	}
	
}

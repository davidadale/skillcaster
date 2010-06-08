package resume.shared.event;

import resume.shared.data.Experience;

import com.google.gwt.event.shared.GwtEvent;

public class ExperienceSavedEvent extends GwtEvent<ExperienceSavedEventHandler> {

	public static Type<ExperienceSavedEventHandler> TYPE = new Type<ExperienceSavedEventHandler>();
	
	private Experience experience;
	
	public ExperienceSavedEvent(Experience experience){
		this.experience = experience;
	}
	
	@Override
	protected void dispatch(ExperienceSavedEventHandler handler) {
		handler.experienceSaved( this );
	}
 
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ExperienceSavedEventHandler> getAssociatedType() {
		return TYPE;
	}

	public Experience getExperience() {
		return experience;
	}

	
	
}

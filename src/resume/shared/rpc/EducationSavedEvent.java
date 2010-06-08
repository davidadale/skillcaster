package resume.shared.rpc;

import resume.shared.data.Education;

import com.google.gwt.event.shared.GwtEvent;

public class EducationSavedEvent extends GwtEvent<EducationSavedEventHandler> {

	
	public static Type<EducationSavedEventHandler> TYPE = new Type<EducationSavedEventHandler>();
	
	Education education;
	
	
	public EducationSavedEvent(Education education) {
		super();
		this.education = education;
	}

	public Education getEducation() {
		return education;
	}

	@Override
	protected void dispatch(EducationSavedEventHandler handler) {
		handler.educationSaved( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<EducationSavedEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	

}

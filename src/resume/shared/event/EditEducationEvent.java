package resume.shared.event;

import resume.shared.data.Education;

import com.google.gwt.event.shared.GwtEvent;

public class EditEducationEvent extends GwtEvent<EditEducationEventHandler> {

	Education education;
	
	
	public EditEducationEvent(Education education) {
		super();
		this.education = education;
	}

	public Education getEducation() {
		return education;
	}

	@Override
	protected void dispatch(EditEducationEventHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<EditEducationEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

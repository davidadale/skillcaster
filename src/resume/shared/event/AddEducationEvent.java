package resume.shared.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddEducationEvent extends GwtEvent<AddEducationEventHandler> {

	public static Type<AddEducationEventHandler> TYPE = new Type<AddEducationEventHandler>();
	
	
	@Override
	protected void dispatch(AddEducationEventHandler handler) {
		handler.addEducation( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddEducationEventHandler> getAssociatedType() {
		return TYPE;
	}

}

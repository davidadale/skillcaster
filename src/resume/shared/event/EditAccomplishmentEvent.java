package resume.shared.event;

import resume.shared.data.Accomplishment;

import com.google.gwt.event.shared.GwtEvent;

public class EditAccomplishmentEvent extends GwtEvent<EditAccomplishmentEventHandler> {

	public static Type<EditAccomplishmentEventHandler> TYPE = new Type<EditAccomplishmentEventHandler>();
	
	private Accomplishment accomplishment;
	
	public EditAccomplishmentEvent(Accomplishment accomplishment) {
		super();
		this.accomplishment = accomplishment;
	}

	@Override
	protected void dispatch(EditAccomplishmentEventHandler handler) {
		handler.editAccomplishment( this );
		
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<EditAccomplishmentEventHandler> getAssociatedType() {
		return TYPE;
	}

	public Accomplishment getAccomplishment() {
		return accomplishment;
	}

}

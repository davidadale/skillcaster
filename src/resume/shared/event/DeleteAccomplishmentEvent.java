package resume.shared.event;

import resume.shared.data.Accomplishment;

import com.google.gwt.event.shared.GwtEvent;

public class DeleteAccomplishmentEvent extends GwtEvent<DeleteAccomplishmentEventHandler> {

	public static Type<DeleteAccomplishmentEventHandler> TYPE = new Type<DeleteAccomplishmentEventHandler>();
	
	Accomplishment accomplishment;
	
	public DeleteAccomplishmentEvent(Accomplishment accomplishment){
		this.accomplishment = accomplishment;
	}
	
	@Override
	protected void dispatch(DeleteAccomplishmentEventHandler handler) {
		handler.deleteAcccomplishment( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DeleteAccomplishmentEventHandler> getAssociatedType() {
		return TYPE;
	}

	public Accomplishment getAccomplishment() {
		return accomplishment;
	}
	
	

}

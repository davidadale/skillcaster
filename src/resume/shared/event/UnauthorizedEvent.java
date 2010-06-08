package resume.shared.event;

import com.google.gwt.event.shared.GwtEvent;

public class UnauthorizedEvent extends GwtEvent<UnauthorizedEventHandler> {

	public static Type<UnauthorizedEventHandler> TYPE = new Type<UnauthorizedEventHandler>();
	
	@Override
	protected void dispatch(UnauthorizedEventHandler handler) {
		handler.unauthorized( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<UnauthorizedEventHandler> getAssociatedType() {
		return TYPE;
	}

}

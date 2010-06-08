package resume.shared.event;

import com.google.gwt.event.shared.GwtEvent;

public class CloseEvent extends GwtEvent<CloseEventHandler> {
	
	public static Type<CloseEventHandler> TYPE = 
		new Type<CloseEventHandler>();
	
	@Override
	protected void dispatch(CloseEventHandler handler) {
		handler.onClose( this );		
	}

	@Override
	public GwtEvent.Type<CloseEventHandler> getAssociatedType() {
		return TYPE;
	}

}

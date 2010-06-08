package resume.shared.event;

import com.google.gwt.event.shared.GwtEvent;

public class SearchForEvent extends GwtEvent<SearchForEventHandler> {

	public static Type<SearchForEventHandler> TYPE = new Type<SearchForEventHandler>();
	
	@Override
	protected void dispatch(SearchForEventHandler handler) {
		handler.onSearchFor( this );
	}

	@Override
	public GwtEvent.Type<SearchForEventHandler> getAssociatedType() {
		return TYPE;
	}

}

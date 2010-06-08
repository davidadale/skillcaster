package resume.shared.event;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.event.shared.GwtEvent;



/**
 * Fired when an action is canceled and the screen
 * the application needs to be updated.
 * 
 * @author daviddale
 *
 */
public class CancelEvent extends GwtEvent<CancelEventHandler> {

	public static Type<CancelEventHandler> TYPE = 
		new Type<CancelEventHandler>();
	
	WidgetPresenter<? extends WidgetDisplay> presenter;
	
	public CancelEvent(WidgetPresenter<? extends WidgetDisplay> presenter) {
		super();
		this.presenter = presenter;
	}

	@Override
	protected void dispatch(CancelEventHandler handler) {
		handler.onCancel( this );		
	}

	@Override
	public GwtEvent.Type<CancelEventHandler> getAssociatedType() {
		return TYPE;
	}

	public WidgetPresenter<? extends WidgetDisplay> getPresenter() {
		return presenter;
	}
	
}

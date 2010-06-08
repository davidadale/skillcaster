package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Fired when an action is completed and the screen needs to 
 * close.
 * @author daviddale
 *
 */
public interface CloseEventHandler extends EventHandler {
	void onClose(CloseEvent event);
}

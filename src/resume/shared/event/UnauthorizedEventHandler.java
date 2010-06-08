package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface UnauthorizedEventHandler extends EventHandler {
	public void unauthorized(UnauthorizedEvent event);
}

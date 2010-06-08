package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface CancelEventHandler extends EventHandler {
	void onCancel(CancelEvent event);
}

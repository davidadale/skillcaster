package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface ProfileUpdateEventHandler extends EventHandler {

	void profileUpdated(ProfileUpdateEvent event);
}

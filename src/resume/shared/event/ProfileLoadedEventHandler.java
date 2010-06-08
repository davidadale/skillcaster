package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface ProfileLoadedEventHandler extends EventHandler {
	void onProfileLoaded(ProfileLoadedEvent event);
}

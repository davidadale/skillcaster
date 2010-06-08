package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface ProfileSavedEventHandler extends EventHandler {
	public void saveProfile(ProfileSavedEvent event);
} 

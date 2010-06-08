package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface LoginSuccessfulEventHandler extends EventHandler {
	void onLoginSuccessful(LoginSuccessfulEvent event);
}

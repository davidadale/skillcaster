package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface MessageHandler extends EventHandler {
	void handle(Message msg);
}

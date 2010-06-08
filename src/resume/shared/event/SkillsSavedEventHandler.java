package resume.shared.event;

import com.google.gwt.event.shared.EventHandler;

public interface SkillsSavedEventHandler extends EventHandler {
	void skillsSaved(SkillsSavedEvent event);
}

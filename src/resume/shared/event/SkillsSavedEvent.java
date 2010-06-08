package resume.shared.event;

import java.util.List;

import resume.shared.data.Skill;

import com.google.gwt.event.shared.GwtEvent;

public class SkillsSavedEvent extends GwtEvent<SkillsSavedEventHandler> {

	public static Type<SkillsSavedEventHandler> TYPE = new Type<SkillsSavedEventHandler>();
	
	List<Skill> skills;
	
	public SkillsSavedEvent(List<Skill> skills) {
		super();
		this.skills = skills;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	@Override
	protected void dispatch(SkillsSavedEventHandler handler) {
		handler.skillsSaved( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SkillsSavedEventHandler> getAssociatedType() {
		return TYPE;
	}

}

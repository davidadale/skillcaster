package resume.shared.event;

import java.util.List;

import resume.shared.data.Skill;

import com.google.gwt.event.shared.GwtEvent;

public class EditSkillsEvent extends GwtEvent<EditSkillsEventHandler> {

	public static Type<EditSkillsEventHandler> TYPE = new Type<EditSkillsEventHandler>();
	
	List<Skill> skills;
	
	
	public EditSkillsEvent(List<Skill> skills) {
		super();
		this.skills = skills;
	}

	@Override
	protected void dispatch(EditSkillsEventHandler handler) {
		handler.editSkills( this );
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<EditSkillsEventHandler> getAssociatedType() {
		return TYPE;
	}

	public List<Skill> getSkills() {
		return skills;
	}
	
}

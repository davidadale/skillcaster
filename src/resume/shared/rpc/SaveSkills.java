package resume.shared.rpc;

import java.util.List;

import net.customware.gwt.dispatch.shared.Action;
import resume.shared.data.Skill;

public class SaveSkills implements Action<SaveSkillsResult> {

	private static final long serialVersionUID = -1267415535312462571L;

	List<Skill> skills;
	
	@SuppressWarnings("unused")
	private SaveSkills(){
	}

	public SaveSkills(List<Skill> skills){
		this.skills = skills;
	}

	public List<Skill> getSkills() {
		return skills;
	}
	
	
}

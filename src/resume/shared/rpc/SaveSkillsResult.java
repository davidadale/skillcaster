package resume.shared.rpc;

import java.util.List;

import net.customware.gwt.dispatch.shared.Result;
import resume.shared.data.Skill;

public class SaveSkillsResult implements Result {

	private static final long serialVersionUID = 6460427483002938028L;

	private List<Skill> skills;
	
	@SuppressWarnings("unused")
	private SaveSkillsResult(){
	}
	
	public SaveSkillsResult(List<Skill> skills) {
		super();
		this.skills = skills;
	}

	public List<Skill> getSkills() {
		return skills;
	}

}

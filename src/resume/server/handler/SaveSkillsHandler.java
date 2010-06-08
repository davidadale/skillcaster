package resume.server.handler;

import java.util.ArrayList;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.Repository;
import resume.shared.data.Skill;
import resume.shared.rpc.SaveSkills;
import resume.shared.rpc.SaveSkillsResult;

public class SaveSkillsHandler implements ActionHandler<SaveSkills, SaveSkillsResult> {

	public SaveSkillsResult execute(SaveSkills action, ExecutionContext context)
			throws ActionException {

		Repository<Skill> repo = new Repository<Skill>(Skill.class);

		ArrayList<Skill> skills = new ArrayList<Skill>();
		
		for( Skill skill: action.getSkills() ){
			skills.add( repo.save( skill ) );
		}
		
		return new SaveSkillsResult( skills );
	}

	public Class<SaveSkills> getActionType() {
		return SaveSkills.class;
	}

	public void rollback(SaveSkills arg0, SaveSkillsResult arg1,
			ExecutionContext arg2) throws ActionException {
		
	}

}

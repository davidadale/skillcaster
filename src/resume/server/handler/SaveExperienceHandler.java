package resume.server.handler;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.Repository;
import resume.shared.data.Experience;
import resume.shared.rpc.SaveExperience;
import resume.shared.rpc.SaveExperienceResult;

public class SaveExperienceHandler implements ActionHandler<SaveExperience, SaveExperienceResult> {

	public SaveExperienceResult execute(SaveExperience action, ExecutionContext ctx)
			throws ActionException {
		Repository<Experience> repo = new Repository<Experience>(Experience.class);
		repo.save( action.getExperience() );
		return new SaveExperienceResult( action.getExperience());
	}

	public Class<SaveExperience> getActionType() {
		return SaveExperience.class;
	}

	public void rollback(SaveExperience arg0, SaveExperienceResult arg1,
			ExecutionContext arg2) throws ActionException {
		
	}

}

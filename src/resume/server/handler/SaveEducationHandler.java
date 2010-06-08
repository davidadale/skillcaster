package resume.server.handler;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.Repository;
import resume.shared.data.Education;
import resume.shared.rpc.SaveEducation;
import resume.shared.rpc.SaveEducationResult;

public class SaveEducationHandler implements ActionHandler<SaveEducation, SaveEducationResult> {

	public SaveEducationResult execute(SaveEducation action, ExecutionContext context)
			throws ActionException {
		
		Repository<Education> repo = new Repository<Education>(Education.class);
		return new SaveEducationResult( repo.save( action.getEducation()  ) );
		
	}

	public Class<SaveEducation> getActionType() {
		return SaveEducation.class;
	}

	public void rollback(SaveEducation arg0, SaveEducationResult arg1,
			ExecutionContext arg2) throws ActionException {
		
	}

}

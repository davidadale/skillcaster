package resume.server.handler;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.Repository;
import resume.shared.data.Accomplishment;
import resume.shared.data.Education;
import resume.shared.data.Experience;
import resume.shared.rpc.DeleteAccomplishment;
import resume.shared.rpc.VoidResult;

public class DeleteAccomplishmentHandler implements ActionHandler<DeleteAccomplishment, VoidResult> {

	public VoidResult execute(DeleteAccomplishment action, ExecutionContext context)
			throws ActionException {
		
		Accomplishment item = action.getItem(); 
		
		if( item instanceof Experience){
			getExperienceRepo().delete( (Experience) action.getItem() , action.getItem().getId() );	
		}else if( item instanceof Education){
			getEducationRepo().delete( (Education)action.getItem(), action.getItem().getId() );
		}
		
		return new VoidResult();
	}
	
	protected Repository<Education> getEducationRepo(){
		return new Repository<Education>(Education.class);
	}
	
	protected Repository<Experience> getExperienceRepo(){
		return new Repository<Experience>(Experience.class);
	}

	public Class<DeleteAccomplishment> getActionType() {
		return DeleteAccomplishment.class;
	}

	public void rollback(DeleteAccomplishment arg0, VoidResult arg1,
			ExecutionContext arg2) throws ActionException {
		// TODO Auto-generated method stub
		
	}

}

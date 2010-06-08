package resume.server.handler;

import javax.jdo.PersistenceManager;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.PMF;
import resume.shared.rpc.SaveBio;
import resume.shared.rpc.SaveBioResult;

public class SaveBioHandler implements ActionHandler<SaveBio, SaveBioResult> {

	public SaveBioResult execute(SaveBio action, ExecutionContext context)
			throws ActionException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try{
			pm.makePersistent( action.getBio() );
		}finally{
			pm.close();
		}
		
		return new SaveBioResult();
		
	}

	public Class<SaveBio> getActionType() {
		return SaveBio.class;
	}

	public void rollback(SaveBio action, SaveBioResult result, ExecutionContext context)
			throws ActionException {
		
	}

}

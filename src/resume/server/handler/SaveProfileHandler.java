package resume.server.handler;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import org.apache.commons.logging.Log;

import resume.server.service.Repository;
import resume.shared.data.Profile;
import resume.shared.rpc.SaveProfile;
import resume.shared.rpc.SaveProfileResult;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class SaveProfileHandler implements ActionHandler<SaveProfile,SaveProfileResult> {
	
	//private final Log logger;
	//private final Provider<ServletContext> servletContext;
	//private final Provider<HttpServletRequest> servletRequest;

	@Inject
	public SaveProfileHandler(Log logger,
			Provider<ServletContext> servletContext,
			Provider<HttpServletRequest> servletRequest) {
		
		super();
		//this.logger = logger;
		//this.servletContext = servletContext;
		//this.servletRequest = servletRequest;
		
	}

	public SaveProfileResult execute(SaveProfile action, ExecutionContext context)
			throws ActionException {
		
		Repository<Profile> profileRepo = new Repository<Profile>(Profile.class);
		profileRepo.save( action.getProfile() );
		
		return new SaveProfileResult();
		
	}

	public Class<SaveProfile> getActionType() {
		return SaveProfile.class;
	}

	public void rollback(SaveProfile arg0, SaveProfileResult arg1,
			ExecutionContext arg2) throws ActionException {
		
	}

}

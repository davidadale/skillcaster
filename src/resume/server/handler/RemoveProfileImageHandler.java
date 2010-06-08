package resume.server.handler;

import resume.server.data.ProfileImage;
import resume.server.service.Repository;
import resume.shared.rpc.RemoveProfileImage;
import resume.shared.rpc.VoidResult;
import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

public class RemoveProfileImageHandler implements ActionHandler<RemoveProfileImage, VoidResult> {

	public VoidResult execute(RemoveProfileImage action, ExecutionContext context)
			throws ActionException {
		
		Repository<ProfileImage> repo = new Repository<ProfileImage>(ProfileImage.class);
		ProfileImage image = repo.loadByUsername( action.getUsername() );
		repo.delete( image, image.getId() );
		return new VoidResult();
		
	}

	public Class<RemoveProfileImage> getActionType() {
		return RemoveProfileImage.class;
	}

	public void rollback(RemoveProfileImage arg0, VoidResult arg1,
			ExecutionContext arg2) throws ActionException {

		
	}

}

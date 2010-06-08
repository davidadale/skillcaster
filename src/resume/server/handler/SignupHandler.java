package resume.server.handler;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.Repository;
import resume.server.service.TokenFactory;
import resume.shared.data.Bio;
import resume.shared.data.Profile;
import resume.shared.data.SecurityToken;
import resume.shared.data.User;
import resume.shared.rpc.Signup;
import resume.shared.rpc.SignupResult;

public class SignupHandler implements ActionHandler<Signup,SignupResult>{

	public SignupResult execute(Signup action, ExecutionContext context)
			throws ActionException {
		
		if( userExist(action) ){
			throw new ActionException("User already exists!");
		}
		
		if( profileExist(action) ){
			throw new ActionException("Profile already exists!");
		}

		String username = action.getUser().getUsername();
		action.getProfile().addEmail( username );
		
		getUserRepo().save( action.getUser() );
		getProfileRepo().save( action.getProfile() );
		getBioRepo().save( new Bio( username ) );
		
		SecurityToken token = TokenFactory.get( username  );
		
		Repository<SecurityToken> tokenRepo = new Repository<SecurityToken>(SecurityToken.class);
		tokenRepo.save( token );
		
		return new SignupResult( token );
		
	}
	
	protected Repository<Profile> getProfileRepo(){
		return new Repository<Profile>(Profile.class);
	}
	
	protected Repository<User> getUserRepo(){
		return new Repository<User>(User.class);
	}	
	
	protected Repository<Bio> getBioRepo(){
		return new Repository<Bio>(Bio.class);
	}
	
	protected boolean userExist(Signup action){
		User user = getUserRepo().loadByUsername( action.getUser().getUsername() );
		return (user!=null);
	}
	
	protected boolean profileExist(Signup action){
		Profile profile = getProfileRepo().loadByUsername( action.getUser().getUsername() );
		return (profile!=null);
	}

	public Class<Signup> getActionType() {
		return Signup.class;
	}

	public void rollback(Signup arg0, SignupResult arg1, ExecutionContext arg2)
			throws ActionException {
		
	}

}

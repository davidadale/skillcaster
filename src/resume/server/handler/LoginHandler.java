package resume.server.handler;


import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.Repository;
import resume.server.service.TokenFactory;
import resume.shared.data.SecurityToken;
import resume.shared.data.User;
import resume.shared.rpc.Login;
import resume.shared.rpc.LoginResult;

public class LoginHandler implements ActionHandler<Login,LoginResult> {
	
	public LoginResult execute(Login action, ExecutionContext context)
			throws ActionException {
		
		String username = action.getUser().getUsername();
		String password = action.getUser().getPassword();
		
		Repository<User> repo = new Repository<User>(User.class);
		User user = repo.loadByUsername( username );
		
		if( user==null ){
			throw new ActionException("No user found for '" + username + "'");
		}
		
		if( !user.getPassword().equals(password) ){
			throw new ActionException("Invalid password for user '" + username + "'");
		}
		
		SecurityToken token = TokenFactory.get( username );			
		Repository<SecurityToken> tokenRepo = new Repository<SecurityToken>(SecurityToken.class);
		tokenRepo.save( token );
		
		return new LoginResult( token );
	}

	public Class<Login> getActionType() {
		return Login.class;
	}

	public void rollback(Login action, LoginResult result, ExecutionContext context)
			throws ActionException {
		
	}

}

package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;
import resume.shared.data.User;

public class Login implements Action<LoginResult> {

	private static final long serialVersionUID = 2204690828834993420L;

	User user;
	
	@SuppressWarnings("unused")
	private Login(){
		
	}
	
	public Login(User user){
		this.user = user;
	}

	public User getUser() {
		return user;
	}
 	
}

package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Result;
import resume.shared.data.SecurityToken;

public class LoginResult implements Result  {

	private static final long serialVersionUID = 8611010723859757099L;
	
	SecurityToken token;

	@SuppressWarnings("unused")
	private LoginResult(){
		
	}
	
	public LoginResult(SecurityToken token) {
		super();
		this.token = token;
	}

	public SecurityToken getToken() {
		return token;
	}
	
}
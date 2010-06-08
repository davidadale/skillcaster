package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Result;
import resume.shared.data.SecurityToken;



public class SignupResult implements Result{

	private static final long serialVersionUID = 8658983491339617114L;

	SecurityToken token;
	
	@SuppressWarnings("unused")
	private SignupResult(){
		
	}

	public SignupResult(SecurityToken token) {
		super();
		this.token = token;
	}

	public SecurityToken getToken() {
		return token;
	}

}

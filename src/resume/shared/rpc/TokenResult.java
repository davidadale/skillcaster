package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Result;
import resume.shared.data.SecurityToken;

public class TokenResult implements Result {

	private static final long serialVersionUID = -9143490437008092197L;
	
	SecurityToken token;
	
	@SuppressWarnings("unused")
	private TokenResult(){
		
	}
	
	public TokenResult( SecurityToken token ){
		this.token = token;
	}

	public SecurityToken getToken() {
		return token;
	}
	
}

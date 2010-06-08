package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;



public class GetProfile implements Action<GetProfileResult> {
	
	private static final long serialVersionUID = 4043235737072844033L;
	
	String username;
	
	@SuppressWarnings("unused")
	private GetProfile(){
		
	}

	public GetProfile(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

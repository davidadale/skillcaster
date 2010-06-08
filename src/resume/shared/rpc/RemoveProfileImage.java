package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;

public class RemoveProfileImage implements Action<VoidResult> {

	private static final long serialVersionUID = 7292237690408266906L;

	String username;
	
	@SuppressWarnings("unused")
	private RemoveProfileImage(){
		
	}
	
	public RemoveProfileImage(String username){
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	
}

package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;
import resume.shared.data.Profile;

public class SaveProfile implements Action<SaveProfileResult> {

	private static final long serialVersionUID = 6091608911363995345L;

	Profile profile;
	
	@SuppressWarnings("unused")
	private SaveProfile(){
		
	}
	
	public SaveProfile(Profile profile){
		this.profile = profile;
	}

	public Profile getProfile() {
		return profile;
	}
	
}

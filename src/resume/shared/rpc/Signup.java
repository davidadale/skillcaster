package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;
import resume.shared.data.Profile;
import resume.shared.data.User;


public class Signup implements Action<SignupResult> {

	private static final long serialVersionUID = 2060936532951087384L;

	private Profile profile;
	private User user;
	
	@SuppressWarnings("unused")
	private Signup(){
		
	}

	public Signup(Profile profile, User user) {
		super();
		this.profile = profile;
		this.user = user;
	}

	public Profile getProfile() {
		return profile;
	}

	public User getUser() {
		return user;
	}
	
}

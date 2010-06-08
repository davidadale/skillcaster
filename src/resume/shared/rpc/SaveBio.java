package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;
import resume.shared.data.Bio;

public class SaveBio implements Action<SaveBioResult>{

	private static final long serialVersionUID = -3132057376919445894L;

	Bio bio;

	@SuppressWarnings("unused")
	private SaveBio(){
		
	}
	
	public SaveBio(Bio bio) {
		super();
		this.bio = bio;
	}

	public Bio getBio() {
		return bio;
	}

	
}

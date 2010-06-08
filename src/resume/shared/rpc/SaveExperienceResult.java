package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Result;
import resume.shared.data.Experience;

public class SaveExperienceResult implements Result {

	private static final long serialVersionUID = 7072602733077186726L;

	Experience experience;

	@SuppressWarnings("unused")
	private SaveExperienceResult(){
		
	}
	
	public SaveExperienceResult(Experience experience) {
		super();
		this.experience = experience;
	}

	public Experience getExperience() {
		return experience;
	}
	
}

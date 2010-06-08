package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;
import resume.shared.data.Experience;

public class SaveExperience implements Action<SaveExperienceResult> {

	private static final long serialVersionUID = -5062811079453506179L;

	Experience experience;
	
	@SuppressWarnings("unused")
	private SaveExperience(){
		
	}
	
	public SaveExperience(Experience exp){
		this.experience = exp;
	}

	public Experience getExperience() {
		return experience;
	}
	
	
	
}

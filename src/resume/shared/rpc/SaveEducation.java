package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;
import resume.shared.data.Education;

@SuppressWarnings("serial")
public class SaveEducation implements Action<SaveEducationResult> {

	Education education;

	@SuppressWarnings("unused")
	private SaveEducation(){
		
	}
	
	
	public SaveEducation(Education education) {
		super();
		this.education = education;
	}

	public Education getEducation() {
		return education;
	}
	
}

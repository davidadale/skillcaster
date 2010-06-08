package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Result;
import resume.shared.data.Education;

@SuppressWarnings("serial")
public class SaveEducationResult implements Result {

	private Education education;

	@SuppressWarnings("unused")
	private SaveEducationResult(){
	}
	
	public SaveEducationResult(Education education) {
		super();
		this.education = education;
	}

	public Education getEducation() {
		return education;
	}
	
}

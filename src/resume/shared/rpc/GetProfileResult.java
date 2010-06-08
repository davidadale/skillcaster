package resume.shared.rpc;

import java.util.ArrayList;
import java.util.List;

import net.customware.gwt.dispatch.shared.Result;
import resume.shared.data.Accomplishment;
import resume.shared.data.Bio;
import resume.shared.data.Education;
import resume.shared.data.Experience;
import resume.shared.data.Profile;
import resume.shared.data.Skill;

public class GetProfileResult implements Result {

	private static final long serialVersionUID = 1700693269569742784L;
	
	Profile profile;
	Bio bio;
	List<Accomplishment> accomplishments = new ArrayList<Accomplishment>();
	List<Skill> skills = new ArrayList<Skill>();
	
	@SuppressWarnings("unused")
	private GetProfileResult(){
		
	}

	public GetProfileResult(Profile profile, Bio bio) {
		super();
		this.profile = profile;
		this.bio = bio;
	}

	public Profile getProfile() {
		return profile;
	}

	public Bio getBio() {
		return bio;
	}
	
	public List<Accomplishment> getAccomplishments() {
		return accomplishments;
	}

	public void addExperiences(List<Experience> experiences){
		this.accomplishments.addAll( experiences );
	}
	
	public void addEducation(List<Education> education){
		this.accomplishments.addAll( education );
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
}

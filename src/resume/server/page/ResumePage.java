package resume.server.page;

import java.util.ArrayList;
import java.util.List;

import resume.server.service.Repository;
import resume.shared.data.Accomplishment;
import resume.shared.data.Bio;
import resume.shared.data.Experience;
import resume.shared.data.Profile;
import resume.shared.data.Skill;

import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;

@At("/user2/:username")
public class ResumePage {

	private Profile profile;
	private Bio bio;
	private List<Skill> skills = new ArrayList<Skill>();
	private List<Accomplishment> accomplishments = new ArrayList<Accomplishment>();
	
	@Get
	public void get(@Named("username") String username){

		profile = getProfileRepo().loadByUsername( username );
		skills = getSkillRepo().findAllByUserName( username );
		bio = getBioRepo().loadByUsername( username );
		skills = getSkillRepo().findAllByUserName( username );
		accomplishments.addAll( getExperienceRepo().findAllByUserName(username) );
	}
	
	protected Repository<Experience> getExperienceRepo(){
		return new Repository<Experience>(Experience.class);
	}
	
	protected Repository<Profile> getProfileRepo(){
		return new Repository<Profile>(Profile.class);
	}
	
	protected Repository<Bio> getBioRepo(){
		return new Repository<Bio>(Bio.class);
	}
	
	protected Repository<Skill> getSkillRepo(){
		return new Repository<Skill>(Skill.class);
	}
	
	public List<Skill> getSkills(){
		return skills;
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
	
	
}

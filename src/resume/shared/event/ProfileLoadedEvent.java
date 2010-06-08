package resume.shared.event;

import java.util.List;

import resume.shared.data.Accomplishment;
import resume.shared.data.Bio;
import resume.shared.data.Profile;
import resume.shared.data.Skill;

import com.google.gwt.event.shared.GwtEvent;

public class ProfileLoadedEvent extends  GwtEvent<ProfileLoadedEventHandler> {

	public static Type<ProfileLoadedEventHandler> TYPE = 
		new Type<ProfileLoadedEventHandler>();

	private Profile profile;
	private Bio bio;
	private List<Accomplishment> accomplisments;
	private List<Skill> skills;
	
	public ProfileLoadedEvent(Profile profile, Bio bio, List<Accomplishment> accomplishments, List<Skill> skills) {
		super();
		this.profile = profile;
		this.bio = bio;
		this.accomplisments = accomplishments;
		this.skills = skills;
	}

	@Override
	protected void dispatch(ProfileLoadedEventHandler handler) {
		handler.onProfileLoaded( this );
	}

	@Override
	public Type<ProfileLoadedEventHandler> getAssociatedType() {
		return TYPE;
	}

	public Profile getProfile() {
		return profile;
	}

	public Bio getBio() {
		return bio;
	}

	public List<Accomplishment> getAccomplisments() {
		return accomplisments;
	}

	public List<Skill> getSkills() {
		return skills;
	}
	
	
}


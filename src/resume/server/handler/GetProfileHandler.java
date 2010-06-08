package resume.server.handler;

import java.util.List;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.Repository;
import resume.shared.data.Bio;
import resume.shared.data.Education;
import resume.shared.data.Experience;
import resume.shared.data.Profile;
import resume.shared.data.Skill;
import resume.shared.rpc.GetProfile;
import resume.shared.rpc.GetProfileResult;

public class GetProfileHandler implements
		ActionHandler<GetProfile, GetProfileResult> {

	public GetProfileResult execute(GetProfile action, ExecutionContext context)
			throws ActionException {

		Repository<Profile> profileRepo = new Repository<Profile>( Profile.class );
		Profile profile = profileRepo.loadByUsername( action.getUsername() );
		
		Repository<Bio> bioRepo = new Repository<Bio>(Bio.class);
		Bio bio = bioRepo.loadByUsername( action.getUsername() );
		
		Repository<Experience> expRepo = new Repository<Experience>( Experience.class );
		List<Experience> experiences = expRepo.findAllByUserName( action.getUsername() );
		
		Repository<Education> eduRepo = new Repository<Education>(Education.class);
		List<Education> education = eduRepo.findAllByUserName( action.getUsername() );
		
		Repository<Skill> skillRepo = new Repository<Skill>(Skill.class);
		List<Skill> skills = skillRepo.findAllByUserName( action.getUsername() );
		
		GetProfileResult result = new GetProfileResult(profile,bio);
		
		if( isNotEmpty(experiences) ){
			result.addExperiences( experiences );	
		}
		
		if( isNotEmpty( education ) ){
			result.addEducation( education );
		}
		
		if( skills!=null && !skills.isEmpty() ){
			result.setSkills( skills );
		}else{
			result.setSkills( Skill.createEmptyList(action.getUsername()) );
		}
		
		return result;

	}
	
	protected boolean isNotEmpty(List<?> list){
		return (list!=null && !list.isEmpty());
	}

	public Class<GetProfile> getActionType() {
		return GetProfile.class;
	}

	public void rollback(GetProfile action, GetProfileResult result,
			ExecutionContext context) throws ActionException {

	}

}

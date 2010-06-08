package resume.client.view;

import resume.shared.data.Skill;

import com.google.gwt.core.client.GWT;
import com.pietschy.gwt.pectin.client.FieldModel;
import com.pietschy.gwt.pectin.client.FormModel;
import com.pietschy.gwt.pectin.client.bean.BeanModelProvider;

public class SkillsViewFormModel extends FormModel {

	public abstract static class SkillProvider extends BeanModelProvider<Skill>{
	}
	
	FieldModel<String> category;
	FieldModel<String> qualifications;
	
	SkillProvider provider = null;
	
	public SkillsViewFormModel(){
		this.provider = GWT.create(SkillProvider.class);
		category = fieldOfType(String.class).boundTo( provider,"category" );
		qualifications = fieldOfType(String.class).boundTo( provider,"qualifications" );
	}
	
	public void setSkill(Skill skill){
		provider.setBean( skill );
	}
	
	public void commit(){
		provider.commit();
	}
	
}

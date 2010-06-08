package resume.client.component;

import resume.shared.data.Skill;

import com.google.gwt.core.client.GWT;
import com.pietschy.gwt.pectin.client.FieldModel;
import com.pietschy.gwt.pectin.client.FormModel;
import com.pietschy.gwt.pectin.client.bean.BeanModelProvider;

public class SkillModel extends FormModel {
	
	public abstract static class SkillProvider extends BeanModelProvider<Skill>{
	}
	
	//FieldModel<Category> category;
	FieldModel<String> qualifications;
	
	SkillProvider provider;
	
	public SkillModel(){
		provider = GWT.create( SkillProvider.class );
		//category = fieldOfType( Skill.Category.class ).boundTo(provider,"category");
		qualifications = fieldOfType(String.class).boundTo(provider,"qualifications");
	}
	
	public void setSkill(Skill skill){
		provider.setBean(skill);
	}
	
	public void commit(){
		provider.commit();
	}
	
}

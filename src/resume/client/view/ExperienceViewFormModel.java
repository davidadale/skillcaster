package resume.client.view;

import java.util.Date;

import resume.shared.data.Experience;

import com.google.gwt.core.client.GWT;
import com.pietschy.gwt.pectin.client.FieldModel;
import com.pietschy.gwt.pectin.client.FormModel;
import com.pietschy.gwt.pectin.client.bean.BeanModelProvider;


public class ExperienceViewFormModel extends FormModel {

	public abstract static class ExperienceProvider extends
			BeanModelProvider<Experience> {
	}

	private ExperienceProvider provider;	
	
	//FormattedFieldModel<Date> completed;
	FieldModel<Date> completed;
	FieldModel<String> company;
	FieldModel<String> role;
	FieldModel<String> shortDescription;
	
	public ExperienceViewFormModel(){
		this.provider = GWT.create( ExperienceProvider.class );
		completed = fieldOfType(Date.class).boundTo(provider,"completed");
		company = fieldOfType(String.class).boundTo(provider,"client");
		role = fieldOfType(String.class).boundTo(provider,"role");
		shortDescription = fieldOfType(String.class).boundTo(provider,"shortDescription");
	}
	
	public void setExperience(Experience exp){
		provider.setBean(exp);
	}
	
	public void commit(){
		provider.commit();
	}
	
}

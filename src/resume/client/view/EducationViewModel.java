package resume.client.view;

import java.util.Date;

import resume.shared.data.Education;

import com.google.gwt.core.client.GWT;
import com.pietschy.gwt.pectin.client.FieldModel;
import com.pietschy.gwt.pectin.client.FormModel;
import com.pietschy.gwt.pectin.client.bean.BeanModelProvider;

public class EducationViewModel extends FormModel {

	public static abstract class EducationProvider extends BeanModelProvider<Education>{
	}
	
	EducationProvider provider = null;
	
	FieldModel<String> degree;
	FieldModel<String> school;
	FieldModel<Date> completed;
	
	
	
	public EducationViewModel(){
		provider = GWT.create(EducationProvider.class);
		
		degree = fieldOfType(String.class).boundTo(provider,"degree");
		school = fieldOfType(String.class).boundTo(provider,"school");
		completed = fieldOfType(Date.class).boundTo(provider,"completed");
	}
	
	
	public void setEducation(Education edu){
		provider.setBean(edu);
	}
	
	public void commit(){
		provider.commit();
	}
	
}

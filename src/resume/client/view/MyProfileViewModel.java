package resume.client.view;

import resume.shared.data.Bio;

import com.google.gwt.core.client.GWT;
import com.pietschy.gwt.pectin.client.FieldModel;
import com.pietschy.gwt.pectin.client.FormModel;
import com.pietschy.gwt.pectin.client.bean.BeanModelProvider;

public class MyProfileViewModel extends FormModel {

	public abstract static class BioProvider extends BeanModelProvider<Bio> {
	}

	FieldModel<String> story;
	
	BeanModelProvider<Bio> bioProvider;
	
	public MyProfileViewModel(){
		
		bioProvider = GWT.create( BioProvider.class );
		story = fieldOfType(String.class).boundTo(bioProvider,"story");
		
	}
	
	public void commit(){
		bioProvider.commit();
	}
	
	public void setBio(Bio bio){
		bioProvider.setBean( bio );
	}
	

}

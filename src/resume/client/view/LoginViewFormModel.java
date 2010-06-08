package resume.client.view;

import static com.pietschy.gwt.pectin.client.validation.ValidationPlugin.validateField;

import resume.shared.data.User;

import com.google.gwt.core.client.GWT;
import com.pietschy.gwt.pectin.client.FieldModel;
import com.pietschy.gwt.pectin.client.FormModel;
import com.pietschy.gwt.pectin.client.bean.BeanModelProvider;
import com.pietschy.gwt.pectin.client.validation.validator.NotEmptyValidator;

import static com.pietschy.gwt.pectin.client.validation.ValidationPlugin.getValidationManager;

public class LoginViewFormModel extends FormModel {

	public abstract static class UserProvider extends
			BeanModelProvider<User> {
	}

	UserProvider provider;
	
	FieldModel<String> username;
	FieldModel<String> password;

	public LoginViewFormModel(){
		this.provider = GWT.create(UserProvider.class);
		username = fieldOfType(String.class).boundTo( provider,"username" );
		password = fieldOfType(String.class).boundTo( provider,"password" );
		validateField( username ).using( new NotEmptyValidator("Username is required")  );
		validateField( password ).using( new NotEmptyValidator("Password is required")  );
		
	}
	
	public boolean validate(){
		return getValidationManager(this).validate();
	}
	
	public void setUser(User user){
		provider.setBean( user );
	}
	
	public void commit(){
		validate();
		provider.commit();
	}
}

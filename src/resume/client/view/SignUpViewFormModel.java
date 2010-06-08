package resume.client.view;

import resume.shared.data.Profile;
import resume.shared.data.User;

import com.google.gwt.core.client.GWT;
import com.pietschy.gwt.pectin.client.FieldModel;
import com.pietschy.gwt.pectin.client.FormModel;
import com.pietschy.gwt.pectin.client.bean.BeanModelProvider;

public class SignUpViewFormModel extends FormModel{

	public abstract static class ProfileProvider extends BeanModelProvider<Profile>{ }
	public abstract static class UserProvider extends BeanModelProvider<User>{ }
	
	ProfileProvider profileProvider;
	UserProvider userProvider;
	
	FieldModel<String> username;
	FieldModel<String> name;
	FieldModel<String> company;
	
	FieldModel<String> userUsername;
	FieldModel<String> password;
	
	
	public SignUpViewFormModel(){
		profileProvider = GWT.create( ProfileProvider.class );
		userProvider = GWT.create( UserProvider.class );
		username = fieldOfType(String.class).boundTo(profileProvider, "username");
		name = fieldOfType(String.class).boundTo( profileProvider,"name" );
		company = fieldOfType(String.class).boundTo(profileProvider,"company");
		userUsername = fieldOfType(String.class).boundTo(userProvider,"username");
		password = fieldOfType(String.class).boundTo(userProvider,"password");
	}
	
	
	public void setUser(User user){
		userProvider.setBean(user);
	}
	
	public void setProfile(Profile profile){
		profileProvider.setBean(profile);
	}
	
	public void commit(){
		profileProvider.commit();
		userProvider.commit();
	}
}

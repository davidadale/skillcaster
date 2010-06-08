package resume.client.view;

import resume.client.presenter.SignUpPresenter;
import resume.shared.data.Profile;
import resume.shared.data.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;

public class SignUpView extends Composite implements SignUpPresenter.Display {

	private static SignUpViewBinder uiBinder = GWT.create(SignUpViewBinder.class);

	interface SignUpViewBinder extends UiBinder<Widget, SignUpView> {
	}	
	
	
	SignUpViewFormModel model = new SignUpViewFormModel();
	WidgetBinder binder = new WidgetBinder();
	
	@UiField
	TextBox email;
	
	@UiField
	TextBox confirmEmail;
	
	@UiField
	PasswordTextBox password;
	
	@UiField
	PasswordTextBox confirmPassword;
	
	@UiField
	TextBox fullname;
	
	@UiField
	TextBox company;
	
	@UiField
	Button signUp;
	
	
	public SignUpView(){
		
		initWidget( uiBinder.createAndBindUi( this ) ); 
		
		binder.bind( model.username ).to( email );
		binder.bind( model.userUsername ).to( email );
		binder.bind( model.password ).to( password );
		binder.bind( model.name ).to( fullname );
		binder.bind( model.company ).to( company );
	}
	
	
	
	public Widget asWidget() {
		return this;
	}

	public void startProcessing() {
		// TODO Auto-generated method stub
		
	}

	public void stopProcessing() {
		// TODO Auto-generated method stub
		
	}
	
	public void setProfile(Profile profile){
		model.setProfile(profile);
	}
	
	public void commit(){
		model.commit();
	}

	public HasClickHandlers getSignUpButon() {
		return signUp;
	}

	public void setUser(User user) {
		model.setUser( user );
	}

}

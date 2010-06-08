package resume.client.view;

import resume.client.presenter.LoginPresenter;
import resume.shared.data.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Widget;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;
import com.pietschy.gwt.pectin.client.components.EnhancedTextBox;


public class LoginView extends Composite implements LoginPresenter.Display {

	private static LoginViewBinder uiBinder = GWT.create(LoginViewBinder.class);

	interface LoginViewBinder extends UiBinder<Widget, LoginView> {
	}	
	
	LoginViewFormModel model = new LoginViewFormModel();
	WidgetBinder binder = new WidgetBinder();
	
	@UiField
	EnhancedTextBox username;
	
	@UiField
	PasswordTextBox password;
	
	@UiField
	Button login;
	
	public LoginView(){
		initWidget( uiBinder.createAndBindUi( this ) );
		binder.bind(model.username).to(username);
		binder.bind(model.password).to(password);
		username.addKeyPressHandler( pressEnterHandler() );
		password.addKeyPressHandler( pressEnterHandler() );
	}
	
	public HasClickHandlers getLoginButton(){
		return login;
	}
	
	public HasValue<String> getUsername(){
		return username;
	}
	
	public HasValue<String> getPassword(){
		return password;
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
	
	public void setUser(User user){
		model.setUser(user);
	}

	public void commit() {
		model.commit();
	}
	
	public boolean validate(){
		return model.validate();
	}
	
	public void focus(){
		username.setFocus( true );
	}
	
	private KeyPressHandler pressEnterHandler(){
		return new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				if( event.getCharCode()== KeyCodes.KEY_ENTER ){
					// not for sure this is the best solution but
					// it appears that the binding is not happening
					// in time before i hit enter
					// Problem: type in a bad username and then hit enter
					// error message returned. Type in a good username and 
					// hit enter and the error message is returned again.
					// try once more and on the second try all is well.
					DeferredCommand.addCommand(new Command() {
						public void execute() {
							login.click();							
						}
					});
				}
			}
		};
	}

}

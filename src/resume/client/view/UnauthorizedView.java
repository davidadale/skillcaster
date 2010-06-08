package resume.client.view;

import resume.client.presenter.LoginPresenter;
import resume.client.presenter.SignUpPresenter;
import resume.client.presenter.UnauthorizedPresenter;
import resume.client.presenter.SignUpPresenter.Display;
import resume.shared.event.Message;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;

public class UnauthorizedView extends Composite implements
		UnauthorizedPresenter.Display {

	private UnauthorizedViewUiBinder uiBinder = GWT
			.create(UnauthorizedViewUiBinder.class);

	@UiField
	FlowPanel tabs;

	TabPanel tabPanel;

	LoginPresenter.Display loginPanel;
	SignUpPresenter.Display signUpPanel;

	public interface UnauthorizedViewUiBinder extends
			UiBinder<Widget, UnauthorizedView> {
	}

	public UnauthorizedView() {

		initWidget(uiBinder.createAndBindUi(this));
		tabPanel = new TabPanel();
		tabs.add(tabPanel);
		
		
	}

	public void startProcessing() {
		// TODO Auto-generated method stub

	}

	public void stopProcessing() {
		// TODO Auto-generated method stub

	}

	public Widget asWidget() {
		// TODO Auto-generated method stub
		return this;
	}

	public void setSignUpPanel(SignUpPresenter.Display view) {
		tabPanel.add(view.asWidget(), "Sign Up");
	}

	public void setLoginPanel(LoginPresenter.Display view) {
		loginPanel = view;
		tabPanel.add(loginPanel.asWidget(), "Log In");
	}

	public void setSignUpView(Display view) {
		signUpPanel = view;
		tabPanel.add(signUpPanel.asWidget(), "Sign Up");

	}

	public void activateLoginPanel() {

		if (loginPanel != null) {
			tabPanel.selectTab(0);

			DeferredCommand.addCommand(new Command() {
				public void execute() {	
					loginPanel.focus();
				}
			});

		}

	}
	
	public void show(Message msg){
	
	}
}

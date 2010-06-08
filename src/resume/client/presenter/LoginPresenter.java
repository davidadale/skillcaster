package resume.client.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.data.User;
import resume.shared.event.LoginSuccessfulEvent;
import resume.shared.rpc.DispatchCallback;
import resume.shared.rpc.Login;
import resume.shared.rpc.LoginResult;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;

public class LoginPresenter extends WidgetPresenter<LoginPresenter.Display> {

	public interface Display extends WidgetDisplay {
		public HasValue<String> getUsername();

		public HasValue<String> getPassword();

		public HasClickHandlers getLoginButton();

		public void focus();

		public void setUser(User user);

		public void commit();

		public boolean validate();
	}

	DispatchAsync dispatcher;

	User user;

	@Inject
	public LoginPresenter(Display display, EventBus eventBus,
			DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
		display.setUser(user = new User());

	}

	@Override
	public Place getPlace() {
		return null;
	}

	@Override
	protected void onBind() {

		display.getLoginButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				display.commit();

				dispatcher.execute(new Login(user),
						new DispatchCallback<LoginResult>() {
							public void onSuccess(LoginResult result) {
								eventBus.fireEvent(new LoginSuccessfulEvent(
										result.getToken()));
							};
						});
			}

		});

	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {

	}

	@Override
	protected void onUnbind() {
		Log.info("Unbind");
	}

	public void refreshDisplay() {
		Log.info("refreshDisplay");
	}

	public void revealDisplay() {
		Log.info("revealDisplay");
	}

}

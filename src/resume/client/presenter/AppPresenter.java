package resume.client.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.data.Education;
import resume.shared.data.Experience;
import resume.shared.data.SecurityToken;
import resume.shared.event.AddEducationEvent;
import resume.shared.event.AddEducationEventHandler;
import resume.shared.event.AddWorkExperienceEvent;
import resume.shared.event.AddWorkExperienceEventHandler;
import resume.shared.event.CancelEvent;
import resume.shared.event.CancelEventHandler;
import resume.shared.event.EditAccomplishmentEvent;
import resume.shared.event.EditAccomplishmentEventHandler;
import resume.shared.event.EditProfileEvent;
import resume.shared.event.EditProfileEventHandler;
import resume.shared.event.EditSkillsEvent;
import resume.shared.event.EditSkillsEventHandler;
import resume.shared.event.LoginSuccessfulEvent;
import resume.shared.event.LoginSuccessfulEventHandler;
import resume.shared.event.Message;
import resume.shared.event.MessageHandler;
import resume.shared.event.ProfileLoadedEvent;
import resume.shared.event.SignupCompleteEvent;
import resume.shared.event.SignupCompleteEventHandler;
import resume.shared.event.UnauthorizedEvent;
import resume.shared.event.UnauthorizedEventHandler;
import resume.shared.rpc.GetProfile;
import resume.shared.rpc.GetProfileResult;
import resume.shared.rpc.Token;
import resume.shared.rpc.TokenResult;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class AppPresenter extends WidgetPresenter<AppPresenter.Display> {

	HasWidgets container;

	DispatchAsync dispatcher;

	SecurityToken token = null;

	UnauthorizedPresenter unauthorizedPresenter;
	MyProfilePresenter myProfilePresenter;
	ExperiencePresenter experiencePresenter;
	EditProfilePresenter editProfilePresenter;
	EducationPresenter educationPresenter;
	SkillsPresenter skillsPresenter;
	
	
	public interface Display extends WidgetDisplay {
		public void showView( WidgetDisplay display);
		public void closeView( WidgetDisplay display);
		public void show(Message message);		
	}

	@Inject
	public AppPresenter(Display display, EventBus eventBus,
			DispatchAsync dispatcher, MyProfilePresenter myProfilePresenter,
			EditProfilePresenter editProfilePresenter,
			UnauthorizedPresenter unauthorizedPresenter,
			ExperiencePresenter experiencePresenter,
			EducationPresenter educationPresenter,
			SkillsPresenter skillsPresenter) {

		super(display, eventBus);
		this.dispatcher = dispatcher;
		this.unauthorizedPresenter = unauthorizedPresenter;
		this.myProfilePresenter = myProfilePresenter;
		this.experiencePresenter = experiencePresenter;
		this.editProfilePresenter = editProfilePresenter;
		this.educationPresenter = educationPresenter;
		this.skillsPresenter = skillsPresenter;

	}

	/**
	 * Clear the widget container and setup the basic
	 * application structure. Then fire a call to check 
	 * for authorization.
	 * 
	 * @param container
	 */
	public void go(HasWidgets container) {
		this.container = container;
		this.container.add( display.asWidget() );
		checkAuthorization();
	}
	
	/**
	 * Check to see if there is a cookie token available and then check
	 * the token value and make sure it is valid.
	 * 
	 * Generates one of two events: 
	 *        
	 *        UnauthorizedEvent() - if the token is missing or invalid.  
	 * 
	 *        LoginSuccessful(); - if the token is available and valid.
	 */
	protected void checkAuthorization() {

		if (token == null) {
			String tokenValue = Cookies.getCookie("skillcaster-session");
			if (tokenValue != null) {
				dispatcher.execute(new Token(tokenValue),
						new AsyncCallback<TokenResult>() {
							public void onFailure(Throwable caught) {
								eventBus.fireEvent( new UnauthorizedEvent() );
							}

							public void onSuccess(TokenResult result) {
								eventBus.fireEvent( new LoginSuccessfulEvent(
										result.getToken()) );
							}
						});
			} else {
				eventBus.fireEvent( new UnauthorizedEvent() );
			}
		}
	}	
	
	/**
	 * Bind the presenter to the display and show the presenters display in the application
	 * frame.
	 * @param presenter
	 */
	protected void activate(WidgetPresenter<? extends WidgetDisplay> presenter){
		//presenter.bind();
		display.showView( presenter.getDisplay()  );
	}
	
	/**
	 * Unbind the presenter and remove remove display from application frame.
	 * @param presenter
	 */
	protected void deactivate(WidgetPresenter<? extends WidgetDisplay> presenter){
		//presenter.unbind();
		display.closeView( presenter.getDisplay() );
	}


	
	@Override
	protected void onBind() {
		
		this.unauthorizedPresenter.bind();
		this.myProfilePresenter.bind();
		this.experiencePresenter.bind();
		this.editProfilePresenter.bind();
		this.educationPresenter.bind();
		this.skillsPresenter.bind();

		eventBus.addHandler(UnauthorizedEvent.TYPE,
				new UnauthorizedEventHandler() {
					public void unauthorized(UnauthorizedEvent event) {
						activate( unauthorizedPresenter );
					}
				});
		
		eventBus.addHandler(LoginSuccessfulEvent.TYPE,
				new LoginSuccessfulEventHandler() {
					public void onLoginSuccessful(LoginSuccessfulEvent event) {
					
						setToken(event.getToken());
						saveCookie(event.getToken());
						
						deactivate( unauthorizedPresenter );
						activate( myProfilePresenter );						

						loadProfile(event.getToken());
					}
				});
		eventBus.addHandler( SignupCompleteEvent.TYPE , new SignupCompleteEventHandler() {
			public void onSignupComlete(SignupCompleteEvent event) {
					eventBus.fireEvent( new LoginSuccessfulEvent(event.getToken() ) );
			}
		});

		eventBus.addHandler(AddWorkExperienceEvent.TYPE, new AddWorkExperienceEventHandler() {
			public void addWorkExperience(AddWorkExperienceEvent event) {
				experiencePresenter.setExperience( new Experience( token.getUsername() ) );
				activate( experiencePresenter );
			}
		});
		
		eventBus.addHandler( AddEducationEvent.TYPE , new AddEducationEventHandler() {
			public void addEducation(AddEducationEvent event) {
				educationPresenter.setEducation(new Education( token.getUsername() ) );
				activate( educationPresenter );
			}
		});
	
		eventBus.addHandler(EditAccomplishmentEvent.TYPE, new EditAccomplishmentEventHandler() {
			public void editAccomplishment(EditAccomplishmentEvent event) {
				if( event.getAccomplishment() instanceof Experience ){
					experiencePresenter.setExperience((Experience)event.getAccomplishment() );
					activate( experiencePresenter );
				}else if( event.getAccomplishment() instanceof Education ){
					educationPresenter.setEducation( (Education) event.getAccomplishment() );
					activate( educationPresenter );
				}
			}
		});
		
//		eventBus.addHandler(EditExperienceEvent.TYPE, new EditExperienceEventHandler() {			
//			public void editExperience(EditExperienceEvent event) {
//				experiencePresenter.setExperience( event.getExperience() );
//				activate( experiencePresenter );
//			}
//		});
		
		eventBus.addHandler(EditProfileEvent.TYPE, new EditProfileEventHandler() {
			public void editProfile(EditProfileEvent event) {
					editProfilePresenter.setProfile( event.getProfile() );
					activate( editProfilePresenter );
			}
		});
		
		eventBus.addHandler(EditSkillsEvent.TYPE, new EditSkillsEventHandler() {
			public void editSkills(EditSkillsEvent event) {
				skillsPresenter.setSkills( event.getSkills() );
				activate( skillsPresenter );
			}
		});
		
		eventBus.addHandler(CancelEvent.TYPE, new CancelEventHandler() {
			public void onCancel(CancelEvent event) {
				deactivate( event.getPresenter() );
			}
		});
		
		
		eventBus.addHandler( Message.TYPE, new MessageHandler() {
			public void handle(Message msg) {
				display.show( msg );
			}
		});

	}
	
	@Override
	public Place getPlace() {
		return null;
	}

	protected void loadProfile(SecurityToken token) {

		dispatcher.execute(new GetProfile(token.getUsername()),
				new AsyncCallback<GetProfileResult>() {
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
					}

					public void onSuccess(GetProfileResult result) {

						eventBus.fireEvent(new ProfileLoadedEvent(result
								.getProfile(), result.getBio(), result
								.getAccomplishments() , result.getSkills()  )   );

					}
				});
	}

	protected void saveCookie(SecurityToken token) {
		Cookies.setCookie("skillcaster-session", token.getUsername() + ":-:"
				+ token.getToken(), token.getExpirationDate(), "127.0.0.1",
				"/", false);
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		Log.info("On Place Request");
	}

	@Override
	protected void onUnbind() {

	}

	public void refreshDisplay() {
		Log.info("Refresh Display");

	}

	public void revealDisplay() {
		Log.info("Reveal Dislay");
	}

	protected void setToken(SecurityToken token) {
		this.token = token;
	}
}

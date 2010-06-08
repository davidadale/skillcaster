package resume.client.gin;


import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.gin.AbstractPresenterModule;
import net.customware.gwt.presenter.client.place.PlaceManager;
import resume.client.CachingDispatchAsync;
import resume.client.presenter.AppPresenter;
import resume.client.presenter.EditProfilePresenter;
import resume.client.presenter.EducationPresenter;
import resume.client.presenter.ExperiencePresenter;
import resume.client.presenter.FramePresenter;
import resume.client.presenter.LoginPresenter;
import resume.client.presenter.MyProfilePresenter;
import resume.client.presenter.SignUpPresenter;
import resume.client.presenter.SkillsPresenter;
import resume.client.presenter.UnauthorizedPresenter;
import resume.client.view.AppView;
import resume.client.view.EditProfileView;
import resume.client.view.EducationView;
import resume.client.view.ExperienceView;
import resume.client.view.FrameView;
import resume.client.view.LoginView;
import resume.client.view.MyProfileView;
import resume.client.view.SignUpView;
import resume.client.view.SkillsView;
import resume.client.view.UnauthorizedView;

import com.google.inject.Singleton;

public class ResumeClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bind( EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
		
		bind( PlaceManager.class).in(Singleton.class);	
		
		bindPresenter( AppPresenter.class, AppPresenter.Display.class, AppView.class);
		bindPresenter( MyProfilePresenter.class,MyProfilePresenter.Display.class, MyProfileView.class);
		bindPresenter( EditProfilePresenter.class, EditProfilePresenter.Display.class,EditProfileView.class);
		bindPresenter( UnauthorizedPresenter.class, UnauthorizedPresenter.Display.class, UnauthorizedView.class);
		bindPresenter( LoginPresenter.class, LoginPresenter.Display.class, LoginView.class);
		bindPresenter( SignUpPresenter.class, SignUpPresenter.Display.class, SignUpView.class );
		bindPresenter( ExperiencePresenter.class, ExperiencePresenter.Display.class, ExperienceView.class);
		bindPresenter( EducationPresenter.class , EducationPresenter.Display.class , EducationView.class );
		bindPresenter( FramePresenter.class, FramePresenter.Display.class, FrameView.class );
		bindPresenter( SkillsPresenter.class, SkillsPresenter.Display.class, SkillsView.class );
		
		bind( CachingDispatchAsync.class );
	}

}

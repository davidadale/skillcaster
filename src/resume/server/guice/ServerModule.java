package resume.server.guice;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import org.apache.commons.logging.Log;

import resume.server.handler.DeleteAccomplishmentHandler;
import resume.server.handler.GetProfileHandler;
import resume.server.handler.LoginHandler;
import resume.server.handler.RemoveProfileImageHandler;
import resume.server.handler.SaveBioHandler;
import resume.server.handler.SaveEducationHandler;
import resume.server.handler.SaveExperienceHandler;
import resume.server.handler.SaveProfileHandler;
import resume.server.handler.SaveSkillsHandler;
import resume.server.handler.SignupHandler;
import resume.server.handler.TokenHandler;

import com.google.inject.Singleton;

public class ServerModule extends ActionHandlerModule {

	@Override
	protected void configureHandlers() {
		bindHandler( LoginHandler.class );
		bindHandler( SignupHandler.class  );
		bindHandler( GetProfileHandler.class );
		bindHandler( SaveProfileHandler.class );
		bindHandler( SaveBioHandler.class );
		bindHandler( RemoveProfileImageHandler.class );
		bindHandler( SaveExperienceHandler.class );
		bindHandler( DeleteAccomplishmentHandler.class );
		bindHandler( TokenHandler.class );
		bindHandler( SaveSkillsHandler.class );
		bindHandler( SaveEducationHandler.class );
		bind(Log.class).toProvider(LogProvider.class).in(Singleton.class);
	}

}

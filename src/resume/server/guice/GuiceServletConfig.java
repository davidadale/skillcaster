package resume.server.guice;

import resume.server.page.ResumePage;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;

public class GuiceServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() { 
		return Guice.createInjector(new DispatchServletModule(),new ServerModule(), new SitebricksModule(){
			@Override
			protected void configureSitebricks() {
				scan( ResumePage.class.getPackage() );
			}
		});
	}

}

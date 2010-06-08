package resume.server.guice;

import net.customware.gwt.dispatch.server.service.DispatchServiceServlet;

import com.google.inject.servlet.ServletModule;

public class DispatchServletModule extends ServletModule  {
	public void configureServlets() {
		serve("/resume/dispatch").with(DispatchServiceServlet.class);
		serve("/image").with( ImageServlet.class );
		serve("/crop").with(CropServlet.class);
	}
}

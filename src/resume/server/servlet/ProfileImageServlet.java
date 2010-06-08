package resume.server.servlet;

import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;

@At("/profile/image/:username")
public class ProfileImageServlet {

	@Get
	public void get(@Named("username") String username ){
		
	
	}
	
	
	
	
}

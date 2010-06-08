package resume.server.guice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

import com.google.inject.Provider;

public class LogProvider implements Provider<Log> {

	public Log get() {
		return new Log4JLogger( "Resume" );
	}

}

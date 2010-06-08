package resume.server.service;

import java.security.SecureRandom;
import java.util.Calendar;

import resume.shared.data.SecurityToken;

public class TokenFactory {
	
	protected static SecureRandom random = new SecureRandom();
	
	public static SecurityToken get(String username){
		long longToken = Math.abs( random.nextLong() );
        String random = Long.toString( longToken, 16 );
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30);
        
        return new SecurityToken( username, random, cal.getTime() );
        
	}
	
	
}

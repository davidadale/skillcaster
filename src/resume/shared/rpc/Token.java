package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;

public class Token implements Action<TokenResult> {

	private static final long serialVersionUID = -7104899324586646639L;

	String username;
	String token;
	
	@SuppressWarnings("unused")
	private Token(){
		
	}
	
	public Token(String cookieValue ){
		if( cookieValue!=null ){
			String[] values = cookieValue.split(":-:");
			username = values[0];
			token = values[1];
		}
		
	}
	
	public Token(String username, String token){
		this.username = username;
		this.token = token;
	}
	
	public String getUsername() {
		return username;
	}

	public String getToken() {
		return token;
	}
	
	
}

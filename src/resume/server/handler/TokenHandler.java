package resume.server.handler;

import java.util.List;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import resume.server.service.Repository;
import resume.shared.data.SecurityToken;
import resume.shared.rpc.Token;
import resume.shared.rpc.TokenResult;

public class TokenHandler implements ActionHandler<Token, TokenResult> {

	public TokenResult execute(Token action, ExecutionContext context)
			throws ActionException {

		Repository<SecurityToken> repo = new Repository<SecurityToken>(SecurityToken.class);
		List<SecurityToken> tokens = repo.findAllByUserName( action.getUsername() );
		
		SecurityToken found = null;
		
		for( SecurityToken token: tokens){
			if( token.getToken().equals( action.getToken() ) ){
				found = token;
				break;
			}
		}
		
		if( found==null ){
			throw new  ActionException("Invalid token");
		}
		
		return new TokenResult( found );
		
	}

	public Class<Token> getActionType() {
		return Token.class;
	}

	public void rollback(Token arg0, TokenResult arg1, ExecutionContext arg2)
			throws ActionException {
		// TODO Auto-generated method stub
		
	}

}

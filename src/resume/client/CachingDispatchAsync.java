package resume.client;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

public class CachingDispatchAsync implements DispatchAsync {

	private DispatchAsync dispatcher;
	
	@Inject
	public CachingDispatchAsync(DispatchAsync dispatcher){
		this.dispatcher = dispatcher;
	}
	
	
	public <A extends Action<R>, R extends Result> void execute(A action,
			AsyncCallback<R> callback) {

		try{
			dispatcher.execute(action, callback);			
		}catch(Exception e){
			e.printStackTrace();
		}

		
	}

}

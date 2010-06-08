package resume.shared.rpc;

import resume.client.Resume;
import resume.shared.event.Message;

import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class DispatchCallback<T> implements AsyncCallback<T> {

	public void onFailure(Throwable caught) {
		caught.printStackTrace();
		Resume.EVENT_BUS.fireEvent( Message.error( caught.getMessage() ) );
	}

	public abstract void onSuccess(T result);


}

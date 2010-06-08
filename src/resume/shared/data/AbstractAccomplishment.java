package resume.shared.data;

import java.io.Serializable;


public abstract class AbstractAccomplishment implements Accomplishment, Comparable<Accomplishment>, Serializable {
	
	private static final long serialVersionUID = -9083436118605431215L;

	public int compareTo(Accomplishment o) {
		return this.getCompletionDate().compareTo( o.getCompletionDate() );
	}

}

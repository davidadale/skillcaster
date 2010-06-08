package resume.shared.data;

import java.io.Serializable;
import java.util.Date;


public interface Accomplishment extends Serializable {
	public Long getId();
	public String getCategory();
	public String getDescription();
	public Date getCompletionDate();
}

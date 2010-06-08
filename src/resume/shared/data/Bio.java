package resume.shared.data;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Bio implements Serializable{

	private static final long serialVersionUID = -6780328122922934376L;

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Long id;

	String username;
	
	String story;

	@SuppressWarnings("unused")
	private Bio(){
		
	}
	
	public Bio(String username){
		this.username = username;
	}

	public Bio(String username, String story) {
		super();
		this.username = username;
		this.story = story;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}
	
	public boolean isEmpty(){
		return (story==null || story.length()==0);
	}
	
	public  boolean isNotEmpty(){
		return !isEmpty();
	}
	
}

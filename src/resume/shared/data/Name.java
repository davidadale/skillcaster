package resume.shared.data;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Name {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    String key;
	
	String username;
	String name;
	
	@SuppressWarnings("unused")
	private Name(){
		
	}

	public Name(String username, String name) {
		super();
		this.username = username;
		this.name = name;
	}
	
	
	

	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName(){
		return this.name;
	}
	
	
}

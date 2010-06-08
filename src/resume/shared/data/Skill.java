package resume.shared.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Skill implements Serializable {

	private static final long serialVersionUID = -223208992700893797L;

	public enum Category{
		Language,
		Platform,
		Framework,
		API,
		Application,
		Technology,
		Database
	}

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Long id;
	
	String username;

	Category category;
	String qualifications;
	
	@SuppressWarnings("unused")
	private Skill(){
		
	}
	
	public Skill(String username, String qualificationList, Category category){
		super();
		this.username = username;
		this.qualifications = qualificationList;
		this.category = category;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	
	
	public static List<Skill> createEmptyList(String username){
		ArrayList<Skill> skills = new ArrayList<Skill>();
		for( Category c: Category.values() ){
			skills.add( new Skill(username,"", c )  );
		}
		return skills;
	}
	
	@NotPersistent
	public boolean isEmpty(){
		return (qualifications==null || qualifications.length()==0);
	}
	
	
	
	
}

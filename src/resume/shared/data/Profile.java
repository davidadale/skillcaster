package resume.shared.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Profile implements Serializable {

	private static final long serialVersionUID = 313531025942756828L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	String username;
	
	String name;

	String title;

	String company;
	
	@Persistent
	List<String> emails;
	
	@Persistent
	List<String> addresses;
	
	@Persistent
	List<String> phoneNumbers;
	
	@Persistent
	List<String> websites;
	
	@Persistent
	List<String> blogs;


	public Profile(){
		
	}
	
	public Profile(String username, String name, String title, String company) {
		super();
		this.username = username;
		this.name = name;
		this.title = title;
		this.company = company;
		//addEmail( username );
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<String> getWebsites() {
		return websites;
	}

	public void setWebsites(List<String> websites) {
		this.websites = websites;
	}

	public List<String> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<String> blogs) {
		this.blogs = blogs;
	}

	public void addEmail(String email){
		if( emails==null ){
			emails = new ArrayList<String>();
		}
		emails.add( email );
	}
	
	public void addAddress(String address){
		if( addresses==null ){
			addresses = new ArrayList<String>();
		}
		addresses.add( address );
	}
	
	public void addPhoneNumber(String number){
		if(phoneNumbers==null){
			phoneNumbers = new ArrayList<String>();
		}
		phoneNumbers.add( number );
	}
	
	public void addWebsite(String url){
		if(websites==null){
			websites = new ArrayList<String>();
		}
		websites.add( url );
	}
	
	public void addBlog(String url){
		if( blogs==null ){
			blogs = new ArrayList<String>();
		}
		blogs.add( url );
	}

}

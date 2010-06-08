package resume.shared.data;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class SecurityToken implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 780324303023655307L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long id;
	
	String username;
	String token;
	Date expirationDate;
	
	@SuppressWarnings("unused")
	private SecurityToken(){
			
	}

	public SecurityToken(String username, String token, Date expirationDate) {
		super();
		this.username = username;
		this.token = token;
		this.expirationDate = expirationDate;
	}

	public String getUsername() {
		return username;
	}

	public String getToken() {
		return token;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public Long getId() {
		return id;
	}
	 
}

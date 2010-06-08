package resume.server.data;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;

@PersistenceCapable
public class ProfileImage implements Serializable {

	
	private static final long serialVersionUID = 1299874843901752622L;

	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Long id;
	String username;
	Blob image;
	Blob croppedImage;
	int x1,x2,y1,y2;
	
	@SuppressWarnings("unused")
	private ProfileImage(){
	}
	
	public ProfileImage(String username){
		this.username = username;
	}
	
	public ProfileImage(String username, byte[] image ) {
		this.username = username;
		this.image = new Blob( image );
	}

	public String getUsername() {
		return username;
	}
	
	public byte[] getImage(){
		return image.getBytes();
	}
	
	public void setImage(byte[] image){
		this.image = new Blob( image );
	}

	public byte[] getCroppedImage(){
		return croppedImage.getBytes();
	}

	public void setCroppedImage(byte[] croppedImage) {
		this.croppedImage =new Blob( croppedImage );
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Long getId() {
		return id;
	}
	
}

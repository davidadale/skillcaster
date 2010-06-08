package resume.shared.data;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Education implements Accomplishment {
	
	private static final long serialVersionUID = -4084901280709052752L;

	public enum Type{
		Degree,
		Certificate,
		Diploma
	}	
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Long id;
	
	String degree;
	
	String school;
	
	Date completed;
	
	Type type = Type.Degree;

	String city;
	
	String username;
	
	@SuppressWarnings("unused")
	private Education(){
		
	}
	
	public Education(String username){
		this.username = username;
	}
	
	
	public Date getCompleted() {
		return completed;
	}

	public String getDegree() {
		return degree;
	}

	public String getSchool() {
		return school;
	}

	@NotPersistent
	public String getCategory() {
		return "Education";
	}
	
	@NotPersistent
	public Date getCompletionDate() {
		return completed;
	}

	@NotPersistent
	public String getDescription() {
		return  type.toString() + " - " + degree;
	}

	public Long getId() {
		return id;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setCompleted(Date completed) {
		this.completed = completed;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}

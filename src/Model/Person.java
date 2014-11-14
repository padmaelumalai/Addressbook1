
/**
 * Person object stores the name, dob and gender of each person in the contact list
 * @author Padma Priya
 *
 */
package Model;

import java.util.Date;

public class Person {
	private String name;
	private String gender;
	private Date dob;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}

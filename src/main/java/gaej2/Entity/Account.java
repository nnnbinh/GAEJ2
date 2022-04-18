package gaej2.Entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Account {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String name;
	@Persistent
	private String city;
	@Persistent
	private String state;
	@Persistent
	private String phone;
	@Persistent
	String website; 
	
	public Account (String name,String city,String state, String phone,String website) {
		this.name=name;
		this.city=city;
		this.state=state;
		this.phone=phone;
		this.website=website;
	}
	
	/** 
	 * @return the id 
	 */ 
	 public Long getId() {
		 return id; 
	 }
	 /** 
	 * @return the name 
	 */ 
	 public String getName() { 
		 return name; 
	 } 
	 /** 
	 * @param name the name to set 
	 */ 
	 public void setName(String name) { 
		 this.name = name; 
	 } 
	 /** 
	 * @return the city 
	 */ 
	 public String getCity() { 
		 return city; 
	 } 
	 /** 
	 * @param city the city to set 
	 */ 
	 public void setCity(String city) { 
		 this.city = city; 
	 } 
	 /** 
	 * @return the state 
	 */ 
	 public String getState() { 
		 return state; 
	 } 
	 /** 
	 * @param state the state to set 
	 */ 
	 public void setState(String state) {
		 this.state = state; 
	 } 
	 /** 
	 * @return the phone 
	 */ 
	 public String getPhone() { 
		 return phone; 
	 } 
	 /** 
	 * @param phone the phone to set 
	 */ 
	 public void setPhone(String phone) { 
		 this.phone = phone; 
	 } 
	 /** 
	 * @return the website 
	 */ 
	 public String getWebsite() { 
		 return website; 
	 } 
	 /** 
	 * @param website the website to set 
	 */ 
	 public void setWebsite(String website) { 
		 this.website = website; 
	 }



}

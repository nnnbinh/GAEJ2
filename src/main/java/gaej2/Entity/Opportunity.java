package gaej2.Entity;

import java.util.Date; 

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Opportunity {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long id;
	
	@Persistent
	private String name;
	@Persistent
	private double amount;
	@Persistent
	private String stageName;
	@Persistent
	private int probability;
	@Persistent
	private Date closeDate;
	@Persistent
	private int orderNumber;
	@Persistent
	private Long accountId;
	
	public Opportunity(String name, double amount, String stageName, int
			probability, Date closeDate, int orderNumber, Long accountId) {
			this.name = name;
			this.amount = amount;
			this.stageName = stageName;
			this.probability = probability;
			this.closeDate = closeDate;
			this.orderNumber = orderNumber;
			this.accountId = accountId;
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
	 * @return the amount 
	 */ 
	 public double getAmount() { 
		 return amount; 
	 } 
	 /** 
	 * @param amount the amount to set 
	 */ 
	 public void setAmount(double amount) { 
		 this.amount = amount; 
	 } 
	 /** 
	 * @return the stageName 
	 */ 
	 public String getStageName() { 
		 return stageName; 
	 } 
	 /** 
	 * @param stageName the stageName to set 
	 */ 
	 public void setStageName(String stageName) { 
		 this.stageName = stageName; 
	 } 
	 /** 
	 * @return the probability 
	 */ 
	 public int getProbability() { 
		 return probability; 
	 } 
	 /** 
	 * @param probability the probability to set 
	 */ 
	 public void setProbability(int probability) { 
		 this.probability = probability; 
	 } 
	 /** 
	 * @return the closeDate 
	 */ 
	 public Date getCloseDate() {
		 return closeDate; 
	 } 
	 /** 
	 * @param closeDate the closeDate to set 
	 */ 
	 public void setCloseDate(Date closeDate) { 
		 this.closeDate = closeDate; 
	 } 
	 /** 
	 * @return the orderNumber 
	 */ 
	 public int getOrderNumber() { 
		 return orderNumber; 
	 } 
	 /** 
	 * @param orderNumber the orderNumber to set 
	 */ 
	 public void setOrderNumber(int orderNumber) { 
		 this.orderNumber = orderNumber; 
	 } 
	 /** 
	 * @return the accountId 
	 */ 
	 public Long getAccountId() { 
		 return accountId; 
	 } 
	 /** 
	 * @param accountId the accountId to set 
	 */ 
	 public void setAccountId(Long accountId) { 
		 this.accountId = accountId; 
	 }
}

/**
 * 
 */
package bookmyshow.sms.mail.api.model;

import javax.validation.constraints.Email;

/**
 * @author M1048474
 *
 */
public class UserPaymentConfirmation {
	
	private String userName;
	@Email
	private String email;
	private String status;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

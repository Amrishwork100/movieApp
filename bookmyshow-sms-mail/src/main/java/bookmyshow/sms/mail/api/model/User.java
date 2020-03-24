/**
 * 
 */
package bookmyshow.sms.mail.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author M1048474
 *
 */
@Entity
@Table(name="mail")
public class User {

	@Id
	@GeneratedValue
	private long userId;
	private String name;
	private String message;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

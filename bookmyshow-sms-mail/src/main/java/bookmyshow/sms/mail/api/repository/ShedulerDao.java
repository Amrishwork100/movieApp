/**
 * 
 */
package bookmyshow.sms.mail.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookmyshow.sms.mail.api.model.User;

/**
 * @author M1048474
 *
 */

@Repository
public interface ShedulerDao extends JpaRepository<User, Long> {

}

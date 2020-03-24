/**
 * 
 */
package bookmyshow.sms.mail.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import bookmyshow.sms.mail.api.model.User;
import bookmyshow.sms.mail.api.repository.ShedulerDao;

/**
 * @author M1048474
 *
 */
@Service
public class ShedulerService {
	
	Logger log=LoggerFactory.getLogger(ShedulerService.class);
	
	@Autowired
	private ShedulerDao shedulerDao;
	
	@Scheduled(fixedRate = 5000L)
	public String send2DB() {
		User user=new User();
		user.setName("Param nath");
		user.setMessage("Spring batch sheduler job");
		shedulerDao.save(user);
		log.info("Save data to DB");
		return "Persist to DB";
	}
	
	@Scheduled(cron = "0/15 * * * * *")
	public String fetchFromDB() {
		List<User> users=shedulerDao.findAll();
		log.info("Fetch Data from DB");
		log.info("Data {} :"  +users.size() );
		
		return "Fetch from DB";
	}
	
	
	
	
	

}

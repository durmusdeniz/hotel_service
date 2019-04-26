package la.demo.hotelapp;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.AclRule;
import la.demo.hotelapp.entity.Hotel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Arrays;

@SpringBootApplication
public class HotelappApplication {


	static String googleServiceAccountId = "";
	static String calendarOwnerMail = "";
	static String googleAppName="hotel-app";

	public static Calendar GOOGLE_CAL_CLIENT;
	public static Hotel DEMO_HOTEL;
	@PostConstruct
	public void init(){
		DEMO_HOTEL = new Hotel("Demo Hotel", 5,5);
		try{

			HttpTransport googleTransport = GoogleNetHttpTransport.newTrustedTransport();
			JacksonFactory googleJsonFactory = JacksonFactory.getDefaultInstance();
			String serviceAccountId = googleServiceAccountId;
			File googleP12File = ResourceUtils.getFile("classpath:google.p12");
			GoogleCredential googleCredential = new GoogleCredential.Builder()
					.setTransport(googleTransport)
					.setJsonFactory(googleJsonFactory)
					.setServiceAccountId(serviceAccountId)
					.setServiceAccountScopes(Arrays.asList(CalendarScopes.CALENDAR))
					.setServiceAccountPrivateKeyFromP12File(googleP12File)
					.build();
			GOOGLE_CAL_CLIENT = new Calendar.Builder(googleTransport, googleJsonFactory,googleCredential).setApplicationName(googleAppName).build();

			AclRule.Scope aclScope = new AclRule.Scope();
			aclScope.setType("user");
			aclScope.setValue(calendarOwnerMail);
			AclRule aclRule = new AclRule();
			aclRule.setScope(aclScope);
			aclRule.setRole("owner");
			GOOGLE_CAL_CLIENT.acl().insert("primary", aclRule).execute();

		}catch (Exception e){
			e.printStackTrace();
		}

	}





	public static void main(String[] args) {

		SpringApplication.run(HotelappApplication.class, args);
	}

}

package la.demo.hotelapp;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.AclRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Arrays;

@SpringBootApplication
public class HotelappApplication {


	public static Calendar GOOGLE_CAL_CLIENT;

	@PostConstruct
	public void init(){
		try{

			HttpTransport googleTransport = GoogleNetHttpTransport.newTrustedTransport();
			JacksonFactory googleJsonFactory = JacksonFactory.getDefaultInstance();
			String serviceAccountId = "service-id-from-google";
			File googleP12File = ResourceUtils.getFile("classpath:google.p12");
			GoogleCredential googleCredential = new GoogleCredential.Builder()
					.setTransport(googleTransport)
					.setJsonFactory(googleJsonFactory)
					.setServiceAccountId(serviceAccountId)
					.setServiceAccountScopes(Arrays.asList(CalendarScopes.CALENDAR))
					.setServiceAccountPrivateKeyFromP12File(googleP12File)
					.build();
			GOOGLE_CAL_CLIENT = new Calendar.Builder(googleTransport, googleJsonFactory,googleCredential).setApplicationName("hotel-app").build();

			AclRule.Scope aclScope = new AclRule.Scope();
			aclScope.setType("user");
			aclScope.setValue("denizdurmus87@yandex.com");
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

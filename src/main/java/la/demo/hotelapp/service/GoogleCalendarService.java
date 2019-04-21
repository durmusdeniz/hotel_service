package la.demo.hotelapp.service;


import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import la.demo.hotelapp.HotelappApplication;
import la.demo.hotelapp.entity.Guest;
import la.demo.hotelapp.entity.Room;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleCalendarService {



    public void addCalendarEvent(
            List<Guest> guests,
            LocalDate checkIn,
            LocalDate checkout,
            Room bookedRoom) throws IOException {

        List<EventAttendee> guestList = new ArrayList<>();

        guests.stream().forEach(guest -> guestList.add(new EventAttendee().setDisplayName(guest.getFullname()).setEmail(guest.getEmail())));

        Event roomBooking = new Event().setSummary("Reservation").setLocation(bookedRoom.toString()).setAttendees(guestList);
        //TODO check the conversion formats
        roomBooking.setStart(new EventDateTime().setDateTime(DateTime.parseRfc3339(checkIn.toString())));
        roomBooking.setEnd(new EventDateTime().setDateTime(DateTime.parseRfc3339(checkout.toString())));

        HotelappApplication.GOOGLE_CAL_CLIENT.events().insert("primary", roomBooking).execute();


    }


}

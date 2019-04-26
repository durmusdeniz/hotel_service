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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class GoogleCalendarService {



    public void addCalendarEvent(
            List<Guest> guests,
            LocalDate checkIn,
            LocalDate checkout,
            Room bookedRoom) {

        try{
            List<EventAttendee> guestList = new ArrayList<>();
            guests.stream().forEach(guest -> guestList.add(new EventAttendee().setDisplayName(guest.getFullname()).setEmail(guest.getEmail().trim())));

            Event roomBooking = new Event().setSummary("Reservation").setLocation(bookedRoom.toString()).setAttendees(guestList);
            roomBooking.setStart(new EventDateTime().setDateTime(new DateTime(Date.from(checkIn.atTime(LocalTime.of(13,0,0)).atZone(TimeZone.getDefault().toZoneId()).toInstant()))));
            roomBooking.setEnd(new EventDateTime().setDateTime(new DateTime(Date.from(checkout.atTime(LocalTime.of(12,0,0)).atZone(TimeZone.getDefault().toZoneId()).toInstant()))));

            HotelappApplication.GOOGLE_CAL_CLIENT.events().insert("primary", roomBooking).execute();
        }catch (IOException e){
            e.printStackTrace();
        }





    }


}

package la.demo.hotelapp.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelTests {




    @Test
    public void testHotelRooms() {
        Hotel hotel = new Hotel("Hotel Name",5,5);

        Assert.assertTrue(hotel.getHotelName().equalsIgnoreCase("Hotel Name"));
        Assert.assertTrue(hotel.getDoubleBedRooms().size() == 5);
        Assert.assertTrue(hotel.getSingleBedRooms().size() == 5);
        Room room = new SingleBedRoom("1");
        LocalDate checkIn = LocalDate.of(2019,4,6);
        LocalDate checkOut = LocalDate.of(2019,4,8);

        Assert.assertTrue(hotel.listEmptyRooms(checkIn, checkOut).size() == (hotel.getSingleBedRooms().size() + hotel.getDoubleBedRooms().size()));
        hotel.bookRoom(room, checkIn, checkOut);
        Assert.assertTrue(hotel.listEmptyRooms(checkIn, checkOut).size() == (hotel.getSingleBedRooms().size() + hotel.getDoubleBedRooms().size())-1);
    }



}



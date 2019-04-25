package la.demo.hotelapp.service;


import com.sun.org.apache.xpath.internal.operations.Bool;
import la.demo.hotelapp.HotelappApplication;
import la.demo.hotelapp.entity.Hotel;
import la.demo.hotelapp.entity.Room;
import la.demo.hotelapp.util.RoomBookRequest;
import la.demo.hotelapp.util.RoomCheckRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HotelService {


    public Set<Room> getEmptyRooms(RoomCheckRequest roomCheckRequest){
        return HotelappApplication
                .DEMO_HOTEL
                .listEmptyRooms(roomCheckRequest.getCheckInDay(), roomCheckRequest.getCheckOutDay());
    }


    public Set<Room> getAllRooms(RoomCheckRequest roomCheckRequest){
        return HotelappApplication
                .DEMO_HOTEL
                .listRooms(roomCheckRequest.getCheckInDay(), roomCheckRequest.getCheckOutDay());
    }



    public Set<Room> bookRoomV2(RoomBookRequest bookingRequest){


        Optional<Room> roomTobook;

        if(bookingRequest.getGuests().size() == 2){
            roomTobook = HotelappApplication
                    .DEMO_HOTEL
                    .listEmptyRooms(bookingRequest.getCheckInDay(), bookingRequest.getCheckOutDay())
                    .stream()
                    .filter(room -> room.getCapacity()==2 && room.getRoomCode().equalsIgnoreCase(bookingRequest.getRoomCode()))
                    .findFirst();
        }else{
            roomTobook = HotelappApplication
                    .DEMO_HOTEL
                    .listEmptyRooms(bookingRequest.getCheckInDay(),bookingRequest.getCheckOutDay())
                    .stream()
                    .filter(room -> room.getCapacity()==1 && room.getRoomCode().equalsIgnoreCase(bookingRequest.getRoomCode()))
                    .findFirst();
        }

        if(roomTobook.isPresent()){
            HotelappApplication.DEMO_HOTEL.bookRoom(roomTobook.get(), bookingRequest.getCheckInDay(), bookingRequest.getCheckOutDay());
        }else{
            System.out.println("No Booking");
        }


        return getAllRooms(new RoomCheckRequest(bookingRequest.getCheckInDay(), bookingRequest.getCheckOutDay()));
    }



    public Boolean bookRoom(RoomBookRequest bookingRequest){

        Optional<Room> roomTobook;

        if(bookingRequest.getGuests().size() == 2){
            roomTobook = HotelappApplication
                    .DEMO_HOTEL
                    .listEmptyRooms(bookingRequest.getCheckInDay(), bookingRequest.getCheckOutDay())
                    .stream()
                    .filter(room -> room.getCapacity()==2)
                    .findFirst();
        }else{
            roomTobook = HotelappApplication
                    .DEMO_HOTEL
                    .listEmptyRooms(bookingRequest.getCheckInDay(),bookingRequest.getCheckOutDay())
                    .stream()
                    .filter(room -> room.getCapacity()==1)
                    .findFirst();
        }

        if(roomTobook.isPresent()){
            HotelappApplication.DEMO_HOTEL.bookRoom(roomTobook.get(), bookingRequest.getCheckInDay(), bookingRequest.getCheckOutDay());
            return true;
        }else{
            return false;
        }

    }
}

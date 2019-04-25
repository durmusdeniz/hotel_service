package la.demo.hotelapp.entity;

import java.time.LocalDate;
import java.util.*;

public class Hotel {



    private String hotelName;
    private HashMap<LocalDate, HashSet<Room>> hotelrooms;
    private HashSet<DoubleBedRoom> doubleBedRooms;
    private HashSet<SingleBedRoom> singleBedRooms;


    public Set<Room> listRooms(LocalDate checkIn, LocalDate checkOut){
        Set<Room> rooms = new HashSet<>();

        rooms.addAll(singleBedRooms);
        rooms.addAll(doubleBedRooms);

        Set<Room> emptyRooms = listEmptyRooms(checkIn,checkOut);

        rooms.stream().forEach(room -> room.setOccupied(true));

        for(Room emptyRoom : emptyRooms){
            emptyRoom.setOccupied(false);
            rooms.add(emptyRoom);
        }

        return rooms;
    }

    public Hotel(String hotelName, Integer singleRoomCapacity, Integer doubleRoomCapacity){

        this.hotelName = hotelName;
        hotelrooms = new HashMap<>();
        doubleBedRooms = new HashSet<>();
        singleBedRooms = new HashSet<>();

        for(int i = 0; i < singleRoomCapacity; i++){
            singleBedRooms.add(new SingleBedRoom(String.valueOf(i+1)));
        }

        for(int i = 0; i < doubleRoomCapacity; i++){
            doubleBedRooms.add(new DoubleBedRoom(String.valueOf(i+1)));
        }

    }

    public Boolean isRoomAvaiableForDay(LocalDate day, Room roomToCheck){

        if(hotelrooms.containsKey(day)){
            return !hotelrooms.get(day).contains(roomToCheck);
        }else{
            return true;
        }

    }

    public Set<Room> listEmptyRooms(LocalDate checkIn, LocalDate checkOut){

        Set<Room> rooms = new HashSet<>();
        LocalDate dayToCheck = checkIn;
        rooms.addAll(singleBedRooms);
        rooms.addAll(doubleBedRooms);

        while(dayToCheck.isBefore(checkOut)){
            //TODO move to optional
            if(hotelrooms.containsKey(dayToCheck)){
                hotelrooms.get(dayToCheck).forEach(room -> rooms.remove(room));
            }
            dayToCheck = dayToCheck.plusDays(1);
        }

        return rooms;
    }

    public void bookRoom(Room roomToBook, LocalDate checkIn, LocalDate checkOut){

        LocalDate dayToBook = checkIn;
        while(dayToBook.isBefore(checkOut)){
            if(hotelrooms.containsKey(dayToBook)){
                hotelrooms.get(dayToBook).add(roomToBook);
            }else{
                hotelrooms.put(dayToBook, new HashSet<>());
                hotelrooms.get(dayToBook).add(roomToBook);
            }

            dayToBook = dayToBook.plusDays(1);
        }

    }

}

package la.demo.hotelapp.util;

import la.demo.hotelapp.entity.Guest;

import java.time.LocalDate;
import java.util.List;

public class RoomBookRequest {

    private LocalDate checkInDay;
    private LocalDate checkOutDay;
    private List<Guest> guests;
    private String roomCode;

    public RoomBookRequest(LocalDate checkInDay, LocalDate checkOutDay, List<Guest> guests, String roomCode) {
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.guests = guests;
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public LocalDate getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(LocalDate checkInDay) {
        this.checkInDay = checkInDay;
    }

    public LocalDate getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(LocalDate checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}

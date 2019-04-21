package la.demo.hotelapp.util;

import java.time.LocalDate;

public class RoomCheckRequest {


    private LocalDate checkInDay;
    private LocalDate checkOutDay;


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

    public RoomCheckRequest(LocalDate checkInDay, LocalDate checkOutDay) {
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
    }
}

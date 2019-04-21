package la.demo.hotelapp.entity;

import java.util.Objects;

public class DoubleBedRoom implements Room
{

    String roomCode;


    public DoubleBedRoom(String roomCode) {
        this.roomCode = "DoubleRoom#"+roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    @Override
    public Integer getCapacity() {
        return 2;
    }

    @Override
    public String toString() {
        return "{\"roomCode\":\""+roomCode+"\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleBedRoom that = (DoubleBedRoom) o;
        return roomCode.equals(that.roomCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomCode);
    }
}

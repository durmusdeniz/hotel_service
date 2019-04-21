package la.demo.hotelapp.entity;

import java.util.Objects;

public class SingleBedRoom implements Room {

    String roomCode;


    public SingleBedRoom(String roomCode) {
        this.roomCode = "SingleRoom#" + roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    @Override
    public Integer getCapacity() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleBedRoom that = (SingleBedRoom) o;
        return roomCode.equals(that.roomCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomCode);
    }

    @Override
    public String toString() {
        return "{\"roomCode\":\""+roomCode+"\"}";
    }
}

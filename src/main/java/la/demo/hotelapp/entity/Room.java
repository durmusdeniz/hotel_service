package la.demo.hotelapp.entity;


public interface Room {

    Integer getCapacity();
    String getRoomCode();
    void setOccupied(Boolean isOccupied);
}

package la.demo.hotelapp.service;


import com.sun.org.apache.xpath.internal.operations.Bool;
import la.demo.hotelapp.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {



    public List<Room> getEmptyRooms(){
        return null;
    }


    public Boolean bookRoom(){
        return true;
    }
}

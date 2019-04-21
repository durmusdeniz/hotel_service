package la.demo.hotelapp.controller;


import la.demo.hotelapp.entity.Room;
import la.demo.hotelapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {


    @Autowired
    private HotelService hotelService;



    @PostMapping("/listemptyrooms")
    public ResponseEntity<List<Room>> listAvaiableRooms(){
        return ResponseEntity.ok(hotelService.getEmptyRooms());
    }

    @PostMapping("/bookroom")
    public ResponseEntity<Boolean> makeBooking(){
        return ResponseEntity.ok(hotelService.bookRoom());
    }

}

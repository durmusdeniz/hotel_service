package la.demo.hotelapp.controller;


import la.demo.hotelapp.entity.Room;
import la.demo.hotelapp.service.HotelService;
import la.demo.hotelapp.util.RoomBookRequest;
import la.demo.hotelapp.util.RoomCheckRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class HotelController {


    @Autowired
    private HotelService hotelService;



    @PostMapping("/listemptyrooms")
    public ResponseEntity<Set<Room>> listAvaiableRooms(@RequestBody RoomCheckRequest roomCheckRequest){
        return ResponseEntity.ok(hotelService.getEmptyRooms(roomCheckRequest));
    }

    @PostMapping("/bookroom")
    public ResponseEntity<Boolean> makeBooking(@RequestBody RoomBookRequest bookingRequest){
        return ResponseEntity.ok(hotelService.bookRoom(bookingRequest));
    }

    @PostMapping("/listrooms")
    public ResponseEntity<Set<Room>> listAllRooms(@RequestBody RoomCheckRequest roomCheckRequest){
        return ResponseEntity.ok(hotelService.getAllRooms(roomCheckRequest));
    }

}

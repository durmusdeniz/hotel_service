package la.demo.hotelapp.controller;


import io.swagger.annotations.ApiOperation;
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


    @PostMapping("/bookwithroom")
    @ApiOperation(value="Makes a room booking with the selected room from the ui")
    public ResponseEntity<Set<Room>> makeBookingV2(@RequestBody RoomBookRequest bookingRequest){
        return ResponseEntity.ok(hotelService.bookRoomV2(bookingRequest));
    }


    @PostMapping("/listemptyrooms")
    @ApiOperation(value="Lists the empty rooms for the check-in and check-out dates")
    public ResponseEntity<Set<Room>> listAvaiableRooms(@RequestBody RoomCheckRequest roomCheckRequest){
        return ResponseEntity.ok(hotelService.getEmptyRooms(roomCheckRequest));
    }

    @PostMapping("/bookroom")
    @ApiOperation(value="Makes a room booking with a random room based on the occupant amount")
    public ResponseEntity<Boolean> makeBooking(@RequestBody RoomBookRequest bookingRequest){
        return ResponseEntity.ok(hotelService.bookRoom(bookingRequest));
    }

    @PostMapping("/listrooms")
    @ApiOperation(value="Lists all of the rooms for the selected dates")
    public ResponseEntity<Set<Room>> listAllRooms(@RequestBody RoomCheckRequest roomCheckRequest){
        return ResponseEntity.ok(hotelService.getAllRooms(roomCheckRequest));
    }

}

package la.demo.hotelapp.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {




    @PostMapping("/listemptyrooms")
    public ResponseEntity listAvaiableRooms(){
        return null;
    }

    @PostMapping("/bookroom")
    public ResponseEntity makeBooking(){
        return null;
    }

}

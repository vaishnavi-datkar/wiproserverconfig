package com.wipro.mobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.mobile.service.MobileService;

@RestController
public class MobileController {

    @Autowired
    private MobileService mobileService;

    @PostMapping("/mobile")
    public String addMobile(@RequestBody Mobile mobile) {
        mobileService.addMobile(mobile);
        return "Mobile added!";
    }

    @GetMapping("/mobile")
    public List<Mobile> getAllMobiles() {
        return mobileService.getAllMobiles();
    }

    @GetMapping("/mobile/{id}")
    public Mobile getMobile(@PathVariable int id) {
        return mobileService.getMobileById(id);
    }

    @PutMapping("/mobile")
    public String updateMobile(@RequestBody Mobile mobile) {
        mobileService.updateMobile(mobile);
        return "Mobile updated!";
    }

    @DeleteMapping("/mobile")
    public String deleteMobile(@RequestBody Mobile mobile) {
        mobileService.deleteMobile(mobile);
        return "Mobile deleted!";
    }
}

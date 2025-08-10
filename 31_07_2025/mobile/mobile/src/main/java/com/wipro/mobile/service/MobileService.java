package com.wipro.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mobile.Mobile;
import com.wipro.mobile.repo.MobileRepo;

@Service
public class MobileService {

    @Autowired
    private MobileRepo mobileRepo;

    public void addMobile(Mobile mobile) {
        mobileRepo.save(mobile);
    }

    public List<Mobile> getAllMobiles() {
        return mobileRepo.findAll();
    }

    public Mobile getMobileById(int id) {
        return mobileRepo.findById(id);
    }

    public void updateMobile(Mobile mobile) {
        mobileRepo.update(mobile);
    }

    public void deleteMobile(Mobile mobile) {
        mobileRepo.delete(mobile);
    }
}

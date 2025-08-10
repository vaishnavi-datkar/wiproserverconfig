package com.wipro.mobile.repo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import com.wipro.mobile.Mobile;

@Repository
public class MobileRepo {

    private List<Mobile> mobileList = new CopyOnWriteArrayList<>();

    public void save(Mobile mobile) {
        mobileList.add(mobile);
    }

    public List<Mobile> findAll() {
        return mobileList;
    }

    public Mobile findById(int id) {
        Optional<Mobile> result = mobileList.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
        return result.orElse(null);
    }

    public void update(Mobile mobile) {
        int i = 0;
        for (Mobile m : mobileList) {
            if (m.getId() == mobile.getId()) {
                mobileList.set(i, mobile);
                break;
            }
            i++;
        }
    }

    public void delete(Mobile mobile) {
        mobileList.removeIf(m -> m.getId() == mobile.getId());
    }
}

package com.wipro.aop;

import org.springframework.stereotype.Component;

@Component
public class AirTravelProcess {

    public void checkIn(Boolean flag) throws NoSeatAvailableException {
        if (Boolean.TRUE.equals(flag)) {
            System.out.println("Check-in successful.");
        } else {
            throw new NoSeatAvailableException("No seats available for check-in.");
        }
    }

    public void collectBoardingPass() {
        System.out.println("Boarding pass collected.");
    }

    public void doSecurityCheck() {
        System.out.println("Security check completed.");
    }

    public void doBoarding() {
        System.out.println("Boarding done.");
    }
}

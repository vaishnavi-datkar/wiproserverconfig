package com.wipro.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.wipro.aop.NoSeatAvailableException;

@Aspect
@Component
public class AirTravelAspect {

    @Before("execution(* com.wipro.aop.AirTravelProcess.checkIn(..))")
    public void showPhotoId() {
        System.out.println("[Advice] Please show your Photo ID before check-in.");
    }

    @Before("execution(* com.wipro.aop.AirTravelProcess.doSecurityCheck(..)) || execution(* com.wipro.aop.AirTravelProcess.doBoarding(..))")
    public void showBoardingPass() {
        System.out.println("[Advice] Please show your boarding pass.");
    }

    @AfterThrowing(pointcut = "execution(* com.wipro.aop.AirTravelProcess.checkIn(..))", throwing = "ex")
    public void handleNoSeatException(NoSeatAvailableException ex) {
        System.out.println("[Exception Advice] " + ex.getMessage());
    }
}

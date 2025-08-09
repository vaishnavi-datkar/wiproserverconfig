package com.wipro.aop;
import com.wipro.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.config.AppConfig;

        public class App{
            public static void main(String[] args) {
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                AirTravelProcess travel = context.getBean(AirTravelProcess.class);

                try {
                    travel.checkIn(false); 
                    travel.collectBoardingPass();
                    travel.doSecurityCheck();
                    travel.doBoarding();
                } catch (Exception ex) {
                    System.out.println("Caught exception: " + ex.getMessage());
                }
            }
        
        }
    


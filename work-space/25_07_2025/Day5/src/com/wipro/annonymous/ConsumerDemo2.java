package com.wipro.annonymous;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Consumer;

public class ConsumerDemo2 {

	public static void main(String[] args) {
		
		Consumer<ZoneId> time = (zone) -> {
			ZonedDateTime currentTime = ZonedDateTime.now(zone);
			System.out.println("Current time in " + zone + " is: " + currentTime);
		};

		time.accept(ZoneId.of("Europe/London"));
	}
}

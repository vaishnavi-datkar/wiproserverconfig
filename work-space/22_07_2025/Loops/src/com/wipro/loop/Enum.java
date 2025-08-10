package com.wipro.loop;

public class Enum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		String [] days= {"sunday","mon","tues"};
		String day ="sunday";
		if(day.equalsIgnoreCase(days[0]))
		{
			System.out.println("sunday");
		}
*/
		enum Month{
			Jan,
			Feb,
			Mar,
			April,
			May,
			June,
			July,
			Aug,
			Sept
		}
	
		
		for(Month month:Month.values())
		{
			System.out.println(month);
		}
	}

}

package com.wipro.thread;
import java.util.Arrays;
import java.util.List;
public class ThreadDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Thread t=new Thread(()-> System.out.println("running--"));
	//	t.start();
		
 List<String> names = Arrays.asList("Amit", "Jayanta", "Esha", "Mohan", "Uma", "Rita");

		        Thread t1 = new Thread(() -> {
		            for (int i = 0; i <names.size();i++) {
		                String name = names.get(i);
		                char ch1 = Character.toLowerCase(name.charAt(0));
		                if (ch1 == 'a' || ch1 =='e'|| ch1 =='i'|| ch1 =='o'|| ch1=='u'){
		                    names.set(i,name.toUpperCase());
		                }
		            }
		        });

		          Thread t2 = new Thread(() -> {
		            for (int i = 0; i < names.size(); i++){
		                String name = names.get(i);
		                char ch1 = Character.toLowerCase(name.charAt(0));
		                if (!(ch1 =='a' || ch1 =='e' || ch1 =='i' || ch1=='o' || ch1=='u')){
		                    names.set(i,name.toLowerCase());
		                }
		            }
		        });
		        t1.start();
		        t2.start();
		        try {
		            t1.join();
		            t2.join();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		     System.out.println(names);
		    }
		
}

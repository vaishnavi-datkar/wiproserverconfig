package com.wipro.filedemo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "C:\\Users\\Vaishanvi Datkar\\Downloads\\image.jpg";
        String output = "C:\\Users\\Vaishanvi Datkar\\Downloads\\image_new.jpg";

		        try (
		            FileInputStream fi = new FileInputStream(input);
		            FileOutputStream fo = new FileOutputStream(output);
		        ) {
		            byte[] buffer = new byte[1024];
		            int bytesRead=0;

		            while ((bytesRead = fi.read(buffer)) != -1) {
		                fo.write(buffer, 0, bytesRead);
		            }
		        } catch (IOException e) {

		            e.printStackTrace();
		        }
		    }
		}


	



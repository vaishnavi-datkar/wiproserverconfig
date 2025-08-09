package com.wipro.bean.springversion;



import org.springframework.stereotype.Component;

@Component
public class Display {
    private int size;

    public Display() {
        this.size = 6; // default value
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void showSize() {
        System.out.println("Display size: " + size + " inches");
    }
}

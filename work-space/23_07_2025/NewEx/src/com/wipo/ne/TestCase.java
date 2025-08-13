package com.wipo.ne;

public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Converter converter = new Converter();
		System.out.println(converter.convert(5));

        System.out.println(converter.convert(3, 4));

        System.out.println(converter.convert(8.7,0.3,2.2));
	}

}

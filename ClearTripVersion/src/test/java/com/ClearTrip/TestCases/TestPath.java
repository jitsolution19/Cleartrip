package com.ClearTrip.TestCases;

public class TestPath {

	public static void main(String[] args) {
//		String Path ="C:\\Users\\lenovo\\eclipse-workspace\\ClearTripVersion\\src\\test\\resources\\chromedriver-win32\\chromedriver.exe";
	String Path = System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver-win32\\chromedriver.exe";
		System.out.println(Path);
	}

}

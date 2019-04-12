package com.demo.config;

import java.util.Random;

public class Ramdompass {
	public static String pass() {
	Random rs = new Random();
	int pass1 = 1+ rs.nextInt(99999-1);
	String a;
	if(pass1<10&&pass1>0) {
		 a= "0000" + pass1;
		return a;
	}
	else if(pass1>=10 && pass1<100) {
		 a = "000"+pass1;
		return a;
	}else if(pass1>=100 && pass1<1000) {
		 a = "00"+pass1;
		return a;
	}else if(pass1>=1000 && pass1<10000) {
		 a = "0"+pass1;
		return a;
	}else {
		 a = ""+pass1;
		return a;
	}
	
}
}

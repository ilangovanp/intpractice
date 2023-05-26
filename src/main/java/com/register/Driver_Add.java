package com.register;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
public class Driver_Add {

@Test(dataProvider="dp_sum", dataProviderClass=com.register.Add.class)
public void testAdd(Map Calc) {
	
	String s1 = Calc.get("s1").toString();
	String s2 = Calc.get("s2").toString();	
	String res = Calc.get("res").toString();
	
	double num1 = Double.parseDouble(s1);
	double num2 = Double.parseDouble(s2);
	double exp_res = Double.parseDouble(res);
	
	double actual_res = num1+num2;
	
	if(actual_res==exp_res) {
		System.out.println("Pass");
	} else {
		System.out.println("Fail");
	}
	
	
}

}

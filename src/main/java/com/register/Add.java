package com.register;

import java.io.IOException;
import java.util.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelutility.Excel_RW;

public class Add {
	
@DataProvider(name="dp_sum")	
public static Iterator<Object[]> gettestdata() throws IOException {
	
	Excel_RW xl = new Excel_RW("E:\\sum.xlsx");	
	int rowCount = xl.getRowCount("Sheet1");
	int colCount = xl.getColCount("Sheet1", 1);
	
	System.out.println("Total Rows: "+rowCount);
	System.out.println("Total Columns: "+colCount);
	
	List<Object[]> arr_list = new ArrayList<Object[]>();
	
	for(int i=1;i<=rowCount;i++) {
	
	Object[] x = new Object[1];	
	Map<String,String> dMap = new HashMap<String,String>();
	
	for(int j=0;j<colCount;j++) {
		
		String sKey = xl.getCellValue("Sheet1", 0, j);
		String sVal = xl.getCellValue("Sheet1", i, j);
		
		dMap.put(sKey, sVal);

	}
	
	x[0] = dMap;
	arr_list.add(x);
	}

	return arr_list.iterator();
}
	
	

}

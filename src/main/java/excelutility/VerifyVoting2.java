package excelutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class VerifyVoting2 {

	public static void main(String[] args) throws IOException {	
		
		Excel_RW excel= new Excel_RW("C:\\Users\\Ilangovan\\eclipse-workspace\\Demoblaze\\Voting_Eligibility.xlsx");
		
       
		int rc =  excel.getRowCount("sheet1");
		
		System.out.println("No of rows: "+rc);
		
		for(int i=1;i<=rc;i++) {
			
		String cellt=excel.getCellValue("sheet1", i, 2);
		
		if(cellt .length()>0) {
			if(Double.parseDouble(cellt )>=18) {
				excel.writeCellValue("sheet1",i,3,"Eligible for Voting");
			
			} else {
				excel.writeCellValue("sheet1",i,3,"Not Eligible for Voting");	
			}
			
		}
		
						
	}
				
	excel.saveAndClose("C:\\Users\\Ilangovan\\eclipse-workspace\\Demoblaze\\Voting_Eligibility.xlsx");	
	
}

}

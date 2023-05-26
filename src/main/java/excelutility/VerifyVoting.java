package excelutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class VerifyVoting {

	public static void main(String[] args) throws IOException {	
		
		FileInputStream fis = new FileInputStream("E:\\Voting_Eligibility.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rc = ws.getLastRowNum();
		
		System.out.println("No of rows: "+rc);
		
		for(int i=1;i<=rc;i++) {
			
		//String cellt = null;			
		XSSFCell cell = ws.getRow(i).getCell(2);
		
		DataFormatter dt= new DataFormatter();
		String cellt = dt.formatCellValue(cell);
		
		/*
		 * if(cell.getCellType()==cell.CELL_TYPE_STRING) { celltext =
		 * cell.getStringCellValue(); } else
		 * if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) { celltext =
		 * String.valueOf(cell.getNumericCellValue()); } else
		 * if(cell.getCellType()==cell.CELL_TYPE_BLANK) { celltext = ""; }
		 */
		
		
		if(cellt .length()>0) {
			if(Double.parseDouble(cellt )>=18) {
				
				ws.getRow(i).getCell(3).setCellValue("Eligible for Voting");
			} else {
				ws.getRow(i).getCell(3).setCellValue("Not Eligible for Voting");	
			}
			
		}
		
						
	}
		
	fis.close();
	
	FileOutputStream fos = new FileOutputStream("E:\\Voting_Eligibility.xlsx");
	wb.write(fos);
	
	fos.close();
}

}

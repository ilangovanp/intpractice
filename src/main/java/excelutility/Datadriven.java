package excelutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fio = new FileInputStream("C:\\Users\\Ilangovan\\eclipse-workspace\\Demoblaze\\Voting.xlsx");
 
		XSSFWorkbook wb= new XSSFWorkbook(fio);
		XSSFSheet xc=wb.getSheetAt(0);
		int rowNo=xc.getLastRowNum();
		System.out.println(rowNo);
		for(int i=1;i<=rowNo;i++) {
			for(int j=2;j<=3;j++) {
			XSSFCell cellvalue=xc.getRow(i).getCell(j);
			DataFormatter dt= new DataFormatter();
			String cellt = dt.formatCellValue(cellvalue);
			System.out.println(cellt);
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

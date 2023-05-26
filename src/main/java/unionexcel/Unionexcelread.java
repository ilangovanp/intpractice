package unionexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Unionexcelread {
	
	
	
	
	
	
	@Test
	public static Object[][] excelut() throws IOException {
	FileInputStream fio = new FileInputStream("C:\\Users\\Ilangovan\\OneDrive\\Documents\\EMI.xlsx");
	 
	XSSFWorkbook wb= new XSSFWorkbook(fio);
	XSSFSheet xc=wb.getSheetAt(0);
	int rowNo=xc.getLastRowNum();
	int colno=xc.getRow(1).getLastCellNum();
	System.out.println(rowNo);
	System.out.println(colno);
	fio.close();
	
	Object[][] arr= new Object[rowNo][1];
	for(int i=1;i<=rowNo;i++) {
		
		Map<String,String> datamap= new HashMap<String,String>();
		
		for(int j=0;j<colno;j++) {
			datamap.put(xc.getRow(0).getCell(j).toString(), xc.getRow(i).getCell(j).toString());
			
			}
		 arr[i-1][0]=datamap;
	}
	return arr;
	}
}

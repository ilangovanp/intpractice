package excelutility;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Mapindataprovider {
    @DataProvider(name="dp")
	public static Object[][] hello()throws IOException {
		// TODO Auto-generated method stub
		String path="C:\\Users\\Ilangovan\\OneDrive\\Documents\\datamapsel.xlsx";

		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new  XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheetAt(0);
		int rownum=ws.getLastRowNum();
		int colnum= ws.getRow(0).getLastCellNum();
		fis.close();
		
		
		Object[][] gh= new Object[rownum][1];
		for(int i=1;i<=rownum;i++) {
			Map<String,String> ab= new HashMap<String,String>();
			for(int j=0;j<colnum;j++) {
				
				ab.put(ws.getRow(0).getCell(j).toString(), ws.getRow(i).getCell(j).toString());
				
			}
		gh[i-1][0]=ab;
		
		}
		return gh;
	}
   
}

package unionexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writeexcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fio=null;
		try {
			fio = new FileInputStream("C:\\Users\\Ilangovan\\OneDrive\\Documents\\writedata.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		XSSFWorkbook wb= new XSSFWorkbook(fio);
		XSSFSheet xc=wb.getSheetAt(0);
		//int rowNo=xc.getLastRowNum();
		//System.out.println(rowNo);
		//int colno=xc.getRow(1).getLastCellNum();
		//System.out.println(colno);
		
		xc.createRow(0).createCell(3).setCellValue("ho");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Ilangovan\\OneDrive\\Documents\\writedata.xlsx");
		wb.write(fos);
		fio.close();
		fos.close();
		
		
		
	}

}

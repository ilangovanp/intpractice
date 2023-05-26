package unionexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uinionui extends Unionexcelread {

	@Test(dataProvider="emi",dataProviderClass = unionexcel.Unionexcelread.class)

	public static void hel(Map h)   throws InterruptedException, IOException {
		
		  WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		  ChromeOptions(); options.addArguments("--remote-allow-origins=*");
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		  options.merge(capabilities); WebDriver driver = new ChromeDriver(options);
		  driver.get(
		  "https://www.unionbankofindia.co.in/english/loan-emi-calculator.aspx");
		  driver.manage().window().maximize();
		 
		String Loanamount = h.get("Loan amount").toString();
		String Interest = h.get("Interest").toString();
		String period = h.get("Period").toString();
		/*
		 * System.out.println(Loanamount); System.out.println(Interest);
		 * System.out.println(period);
		 */
		
		
		  driver.findElement(By.xpath("//input[@id='loanamount']")).sendKeys(Loanamount); 
		  driver.findElement(By.xpath("//input[@id='rate']")).sendKeys(Interest);
		  driver.findElement(By.xpath("//input[@id='pmonths']")).sendKeys(period);
		  driver.findElement(By.xpath("//input[@id='Button1']")).click();
		 Thread.sleep(3000);
		 
		  String EMI=driver.findElement(By.xpath("//input[@id=\"EMI\"]")).getAttribute("value");
		  String Average_interest =driver.findElement(By.xpath("//input[@id='Avg_int']")).getAttribute("value");
		  String Monthly_interest=driver.findElement(By.xpath("//input[@id='MI']")).getAttribute("value");
		    
		    System.out.println(EMI);
			System.out.println(Average_interest);
			System.out.println(Monthly_interest);
			
			
			  FileInputStream fio = new
			  FileInputStream("C:\\Users\\Ilangovan\\OneDrive\\Documents\\EMIdata.xlsx");
			  
			  XSSFWorkbook wb= new XSSFWorkbook(fio); XSSFSheet xc=wb.getSheetAt(0); int
			  rowNo=xc.getLastRowNum(); int colno=xc.getRow(1).getLastCellNum(); 
			  for(int k=1;k<=rowNo;k++) { //xc.getRow(k).getCell(4).setCellValue("ho");
			  xc.createRow(k).createCell(4).setCellValue(EMI); } 
			  FileOutputStream fos = new FileOutputStream("C:\\Users\\Ilangovan\\OneDrive\\Documents\\EMIdata.xlsx");
			  wb.write(fos); 
			  fio.close(); 
			  fos.close();
			 
		
		driver.quit();;
		
		
	}

}

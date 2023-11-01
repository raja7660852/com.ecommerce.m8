package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromexcelFile {

	public static void main(String[] args) throws Exception {
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		Sheet sh=wb.getSheet("Contacts");
		Row rw=sh.getRow(1);
		Cell c1=rw.getCell(2);
		String value=c1.getStringCellValue();
		System.out.println(value);
		

	}

}

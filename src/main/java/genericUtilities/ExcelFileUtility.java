package genericUtilities;

import java.io.FileInputStream;



import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelFileUtility {
		public String readDataFromEXcel(String sheetname,int rowNum,int cellNum ) throws Exception {
			FileInputStream fise = new FileInputStream("C:\\Selinium Folder\\TestData.xlsx");
			Workbook wb=WorkbookFactory.create(fise);
			String value=wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
			return value;
		}
	   
		
		
		public Object[][] readMultipleData(String sheetName) throws Exception, Exception
		{
			FileInputStream fise = new FileInputStream("C:\\Selinium Folder\\TestData.xlsx");
			Workbook wb=WorkbookFactory.create(fise);
			Sheet sh=wb.getSheet(sheetName);
			int lastRow =sh.getLastRowNum();
			int lastCell= sh.getRow(0).getLastCellNum();
			
			Object[][]	data=new Object[lastRow][lastCell];	
			
			for(int i=0;i<lastRow;i++)
			{
				for(int j=0;j<lastCell;j++)
				{
					data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			return data;
			
		}
			 
		}
	
	
	
	
	




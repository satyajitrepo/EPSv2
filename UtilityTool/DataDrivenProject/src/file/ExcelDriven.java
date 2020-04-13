package file;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {

	public void updateExcel(String file) throws IOException
	{
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		String[] headers = {"Rate *", "Freight per unit value", "GST Percentage"};
		
		XSSFSheet sheet = workbook.getSheet("Price Sheet5");
		
		Row eighthrow = sheet.getRow(8);
		Row ninthrow = sheet.getRow(9);
		
		Iterator<Cell> cellsOfEighthRow = eighthrow.cellIterator();
		
		int index = 0;
		
		for(String header : headers) 
		{
			while(cellsOfEighthRow.hasNext())
			{
				Cell cell = cellsOfEighthRow.next();
				
				System.out.println(cell.getStringCellValue());
				
				if(cell.getStringCellValue().contentEquals(header))
				{	
					ninthrow.getCell(index).setCellValue(5);
					System.out.println(index);
					index++;
					break;
				}
				
				index++;
			}
		}
		
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		out.close();
	}
}

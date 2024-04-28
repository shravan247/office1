package practice1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcel {

	public static void main(String[] args) throws Exception, IOException {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook book = WorkbookFactory.create(fis);

		Sheet s = book.getSheet("Contacts");
		Row row = s.getRow(1);
		Cell cell = row.getCell(2);
		String value = cell.getStringCellValue();

		// String
		// value=book.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		System.out.println(value);
	}

}

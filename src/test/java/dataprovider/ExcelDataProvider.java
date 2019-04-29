package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook workbook;

	public ExcelDataProvider() {

		File src = new File("./ApplicationTestData/AppData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			workbook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getData(int sheetIndex, int row, int col) {
		String data = workbook.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

	public String getData(String sheetName, int row, int col) {
		String data = workbook.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}

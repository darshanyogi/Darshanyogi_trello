package com.qspider.atlasian.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
/**
 * It will be used to read the string data  cell value from the workbook.
 * @author Darshan S
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return cellValue 
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readStringData(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TrelloTestCaseSpecificData.xlsx");
		Workbook workBook = WorkbookFactory.create(fis);
		String cellData = workBook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		workBook.close();
		return cellData;
	}
/**
 * It will be used to read the numeric data  cell value from the workbook.
 * @author Darshan S
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return cellValue 
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public double readNumericData(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resource/TrelloTestcaseSpecificData.xlsx");
		Workbook workBook = WorkbookFactory.create(fis);
		double cellData = workBook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
		workBook.close();
		return cellData;

	}
}

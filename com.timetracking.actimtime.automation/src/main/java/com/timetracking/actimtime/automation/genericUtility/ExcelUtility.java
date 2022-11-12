package com.timetracking.actimtime.automation.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String fetchDataFromExcelSheet(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/excelData.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(cell).toString();
	}

}

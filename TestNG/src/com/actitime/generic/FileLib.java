package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	public static String propertyPath = "./data/commondata.property";
	public static String excelPath = "./data.testScript.xlsx";
	/**
     * Returns the property value associated with the given key from the specified property file.
     * @param key : Key to return the associated property.
     * @param path : Path to the property file.
     * @return : The value associated with the key in the property file.
     * @throws IOException : In case of input/output exception.
     */
    public String getPropertyData(String key) throws IOException {
        try (FileInputStream fis = new FileInputStream(propertyPath)) {
            Properties properties = new Properties();
            properties.load(fis);
            return properties.getProperty(key);
        }
    }
    
    
    
    /**
     * Returns the data from the specified cell as a String.
     * @param path : Path to the excel file.
     * @param sheetName : Name of the sheet in the excel file.
     * @param row : Row index.
     * @param cell : Cell index.
     * @return : The data from the cell as a String.
     * @throws IOException : In case of input/output exception.
     * @throws EncryptedDocumentException : In case of encrypted document.
     */
    public String getExcelData(String path, String sheetName, int row, int cell) throws IOException, EncryptedDocumentException {
        try (FileInputStream fis = new FileInputStream(path)) {
            Workbook workbook = WorkbookFactory.create(fis);
            return workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
        }
    }

    
    
    
    /**
     * Writes the specified value into the given cell in the excel file.
     * @param path : Path to the excel file.
     * @param sheetName : Name of the sheet in the excel file.
     * @param row : Row index.
     * @param cell : Cell index.
     * @param value : The value to write into the cell.
     * @throws IOException : In case of input/output exception.
     * @throws EncryptedDocumentException : In case of encrypted document.
     */
    public void setExcelData(String sheetName, int row, int cell, String value) throws IOException, EncryptedDocumentException {
        try (FileInputStream fis = new FileInputStream(excelPath); 
             FileOutputStream fos = new FileOutputStream(excelPath)) {
            Workbook workbook = WorkbookFactory.create(fis);
            workbook.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
            workbook.write(fos);
        }
    }

}

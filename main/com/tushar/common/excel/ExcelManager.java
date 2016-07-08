package com.tushar.common.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ExcelManager {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ExcelManager.class);
	
	private String templateFileName;
	private String dataDir;
	private String filePrefix;
	private String fileSuffix;
	private String fileName;
	private Workbook wb;
	private FileOutputStream fileOut;
	
	public boolean init(){
		try{
			if(getTemplateFileName() == null){
				wb = new XSSFWorkbook();
			}
			else{
				wb = new XSSFWorkbook(new FileInputStream(getTemplateFileName()));
			}
			fileName = 		getDataDir() + 
							"/" + 
							getFilePrefix() +
							"_" + 
							new Date().getTime() + 
							"." + 
							getFileSuffix();
			return true;
		}
		catch(Exception e){
			logger.error("Could not initialise Excel Manager. Error: {}", e.getMessage());
			return false;
		}
	}
	
	public boolean close(){
		try {
			fileOut = new FileOutputStream(getFileName());
			wb.write(fileOut);
			fileOut.close();
			wb.close();
			return true;
		} catch (IOException e) {
			logger.error("Error while writing/closing the sheet.\nError: {}", e.getMessage());
			return false;
		}
	}
	
	
	public String getDataDir() {
		return dataDir;
	}

	public void setDataDir(String dataDir) {
		this.dataDir = dataDir;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getFileName() {
		return fileName;
	}

	public Sheet getSheet(int index){
		return wb.getSheetAt(index); 
	}
	
	public Sheet createSheet(String sheetName){
		return wb.createSheet(sheetName);
	}
	
	private int rowCount = 0;
	public void addDetailsRow(Object[] values){
		Sheet sheet = getSheet(0);
		Row row = sheet.getRow(25 + rowCount);
		rowCount++;
		row.getCell(0).setCellValue((double) values[0]);
		row.getCell(1).setCellValue((String) values[1]);
		row.getCell(2).setCellValue((double) values[2]);
	}

	public String getTemplateFileName() {
		return getDataDir() + "/" + templateFileName;
	}

	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}

}

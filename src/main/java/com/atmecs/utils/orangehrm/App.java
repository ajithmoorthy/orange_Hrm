package com.atmecs.utils.orangehrm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;;

/**
 * Hello world!
 *
 */
public class App {
	String locator = "locator.dropdown.noOfemp.name";

	public String returnLocator(String locator) throws IOException {

		File file = new File("C:\\Users\\ajith.periyasamy\\ajith\\Test\\src\\main\\resources\\locators.xlsx");
		FileInputStream fileInput = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(fileInput);
		Sheet sheet = book.getSheetAt(0);
		int row1 = sheet.getLastRowNum();
		row1 += 1;
		// System.out.println(row1);
		int col = sheet.getRow(0).getLastCellNum();
		String array[][] = new String[row1][col];
		int count = 0;
		for (Row row : sheet) {
			int count1 = 0;
			for (Cell cell : row) {
				String Data = cell.toString();
				array[count][count1] = Data;
				count1++;
			}
			count++;
		}
		Map<String, String> map = returnarray(array, row1, col);
		String mainloc = map.get(locator);
		return mainloc;
	}

	public Map<String, String> returnarray(String[][] array, int row1, int col) {
		ArrayList<String> list = new ArrayList<String>();
		String temp = null;
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col; j++) {
				if (j == 0) {
					temp = array[i][j];
				} else {
					map.put(temp, array[i][j]);
				}
			}
		}
		return map;

	}
}

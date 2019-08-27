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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Inputfetch {
	public String fetchinput(String input) throws IOException {
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
		String mainloc = map.get(input);
		return mainloc;
	}

	public Map<String, String> returnarray(String[][] array, int row1, int col) {
		ArrayList<String> list = new ArrayList<String>();
		String temp = null;
		String[] inputs = null;
		int initial = 0;
		Map<String, String> map = new HashMap<String, String>();
		for (int initial1 = 0; initial1 < row1; initial1++) {
			for (int count = 0; count < col; count++) {
				if (count == 0) {
					temp = array[initial1][count];
				} else {
					map.put(temp, array[initial1][count]);
				}

			}
		}
		return map;
	}
}

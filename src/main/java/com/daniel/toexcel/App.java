package com.daniel.toexcel;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * Hello world!
 *
 */
public class App {
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }

	// private static void App() throws Exception {
	public static void main(String[] args) throws IOException {
		
		String[] headers = new String[] { "ID", "MARCA", "MODELO", "COLOR" };

		List<Car> data = new ArrayList<Car>();
		data.add(new Car(1, "Citroen", "C1", "Red"));
		data.add(new Car(2, "Citroen", "C3", "Blue"));
		data.add(new Car(3, "Opel", "Astra", "Black"));
		data.add(new Car(4, "Opel", "Omega", "White"));
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "Hoja excel");

		CellStyle headerStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		headerStyle.setFont(font);
		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


		HSSFRow headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; ++i) {
			String header = headers[i];
			HSSFCell cell = headerRow.createCell(i);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(header);
		}

		for (int i = 0; i < data.size(); ++i) {
			HSSFRow dataRow = sheet.createRow(i + 1);

			dataRow.createCell(0).setCellValue(data.get(i).getId());
			dataRow.createCell(1).setCellValue(data.get(i).getBrand());
			dataRow.createCell(2).setCellValue(data.get(i).getModel());
			dataRow.createCell(3).setCellValue(data.get(i).getColour());
		}

		FileOutputStream file = new FileOutputStream("data.xls");
		workbook.write(file);
		file.close();
	}
}

package cn.id5.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReportUtil {

	public static final String CONTENT_TYPE = "application/vnd.ms-excel";

	public static  void setResponseHeader( HttpServletResponse response,String outputnName) throws UnsupportedEncodingException{
		
		  response.setContentType("application/vnd.ms-excel;charset=utf-8");
		   response.setHeader("Content-Disposition", "attachment;filename="
				     + new String(outputnName.getBytes(), "iso-8859-1"));
	}
	public static  void writeToResponse( HSSFWorkbook wb,HttpServletResponse response) throws IOException {
		ServletOutputStream out = response.getOutputStream();
		 out.flush();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}
	public static void setSheetCellValue(HSSFSheet sheet, int rowIndex,
			int colIndex, Object value, int cellType) {
		if (value == null || value.equals("null"))
			return;
		// HSSFComment conment=sheet.getCellComment(rowIndex, colIndex);
		HSSFRow row = sheet.getRow(rowIndex);
		if (row == null) {
		     row = sheet.createRow(rowIndex);
		}
		HSSFCell cell = row.getCell(colIndex, Row.CREATE_NULL_AS_BLANK);
		cell.setCellType(cellType);
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			cell.setCellValue(value.toString());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			cell.setCellValue(Integer.parseInt(value.toString()));
			break;
		default:
			cell.setCellValue(value.toString());
		}
	}

	public static HSSFWorkbook getWb(String filename)
			throws FileNotFoundException {
		try {
			File file = new File(filename);
			FileInputStream fis = new FileInputStream(filename);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			;
			return wb;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public static  void insertToRow(HSSFSheet sheet, int starRow, int rows) {
		if (rows <= 0) {
			return;
		}
		sheet.shiftRows(starRow + 1, sheet.getLastRowNum(), rows, true, false);
		// Parameters:
		// startRow - the row to start shifting
		// endRow - the row to end shifting
		// n - the number of rows to shift
		// copyRowHeight - whether to copy the row height during the shift
		// resetOriginalRowHeight - whether to set the original row's height to
		// the default

		starRow = starRow - 1;

		for (int i = 0; i < rows; i++) {
			HSSFRow sourceRow = null;
			HSSFRow targetRow = null;
			HSSFCell sourceCell = null;
			HSSFCell targetCell = null;
			short m;
			starRow = starRow + 1;
			sourceRow = sheet.getRow(starRow);
			targetRow = sheet.createRow(starRow + 1);
			targetRow.setHeight(sourceRow.getHeight());

			for (m = sourceRow.getFirstCellNum(); m < sourceRow
					.getLastCellNum(); m++) {
				sourceCell = sourceRow.getCell(m);
				targetCell = targetRow.createCell(m);

				// targetCell.setEncoding(sourceCell.getEncoding());
				if (sourceCell != null) {
					targetCell.setCellStyle(sourceCell.getCellStyle());
					targetCell.setCellType(sourceCell.getCellType());
					// targetCell.setCellValue(i);//設置值
				}
			}
		}

	}

}

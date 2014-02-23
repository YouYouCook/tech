package cn.krt.zbcg.system.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.ssi.struts.action.SSIDispatchAction;

import cn.id5.util.ExcelReportUtil;
import cn.krt.zbcg.commons.bo.system.ZhaobiaojinduBO;


public class ExcelexportAction extends SSIDispatchAction{

	
	
	
	private String generateTodayStr(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	

	private static void setSheetCellValue(HSSFSheet sheet, int rowIndex,
			int colIndex, Object value, int cellType){
		ExcelReportUtil.setSheetCellValue(sheet,rowIndex,colIndex,value,cellType);
	}
	private void writeShqd(HSSFWorkbook wb,List list){
		if(list==null ||list.size()==0){
			return ;
		}
		ZhaobiaojinduBO  firstbo = (ZhaobiaojinduBO) list.get(0);
		
		HSSFSheet sheet = wb.getSheet("sheet1");
		setSheetCellValue(sheet,1,3,generateTodayStr(),Cell.CELL_TYPE_STRING);
		
		setSheetCellValue(sheet,2,3,firstbo.getGonghuoshang(),Cell.CELL_TYPE_STRING);
		
		setSheetCellValue(sheet,3,3,firstbo.getLianxiren(),Cell.CELL_TYPE_STRING);
		
		setSheetCellValue(sheet,4,3,firstbo.getDanjia(),Cell.CELL_TYPE_STRING);
		setSheetCellValue(sheet,5,3,firstbo.getZhibaojinjnrq(),Cell.CELL_TYPE_STRING);
		
		setSheetCellValue(sheet,3,8,firstbo.getKaibiaoriqi(),Cell.CELL_TYPE_STRING);
		setSheetCellValue(sheet,4,8,firstbo.getZcjdhrq(),Cell.CELL_TYPE_STRING);
		int starRow = 8;
		ExcelReportUtil.insertToRow(sheet,8,list.size()-4);
	     for(int i=0;i<list.size();i++){
	    	 ZhaobiaojinduBO  bo = (ZhaobiaojinduBO) list.get(i);
	    	 setSheetCellValue(sheet,starRow,2,bo.getPinming(),Cell.CELL_TYPE_STRING);
	    	 setSheetCellValue(sheet,starRow,3,bo.getShuliang(),Cell.CELL_TYPE_STRING);
	     	 setSheetCellValue(sheet,starRow,4,bo.getChandi(),Cell.CELL_TYPE_STRING);
	       	 setSheetCellValue(sheet,starRow,5,bo.getDanjia(),Cell.CELL_TYPE_STRING);
	       	 setSheetCellValue(sheet,starRow,6,bo.getJine(),Cell.CELL_TYPE_STRING);
	    	 setSheetCellValue(sheet,starRow,7,bo.getZhibaojin(),Cell.CELL_TYPE_STRING);
	    	 setSheetCellValue(sheet,starRow,8,bo.getZhuangxiefei(),Cell.CELL_TYPE_STRING);
	    	 setSheetCellValue(sheet,starRow,9,bo.getQrjhrq(),Cell.CELL_TYPE_STRING);
	    	 setSheetCellValue(sheet,starRow,10,bo.getPinzhongshuxing(),Cell.CELL_TYPE_STRING);
	    	 setSheetCellValue(sheet,starRow,11,bo.getBeizhu(),Cell.CELL_TYPE_STRING);
	    	 starRow++;
	     }
	}




	
	public ActionForward exportylghd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(ExcelReportUtil.CONTENT_TYPE);
		response.reset();
		String template = "shqd.xls";
		String outPutname = "原料订货单.xls";
		ExcelReportUtil.setResponseHeader(response, outPutname);
		String filePath = request.getSession().getServletContext()
				.getRealPath("")
				+ "/uploadfiles/reports/" + template;
		List list = (List) request.getSession().getAttribute("zhaobiaoList");
		System.out.println(list);
		try {
			HSSFWorkbook wb = ExcelReportUtil.getWb(filePath);
			writeShqd(wb,list);
			ExcelReportUtil.writeToResponse(wb,response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	

}

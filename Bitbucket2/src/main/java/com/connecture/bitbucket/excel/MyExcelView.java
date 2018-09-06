package com.connecture.bitbucket.excel;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.connecture.bitbucket.pullrequest.FinalData;



public class MyExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) {
		// VARIABLES REQUIRED IN MODEL
		String sheetName = (String) model.get("sheetname");
		List<String> headers = (List<String>) model.get("headers");
		List<FinalData> results = (List<FinalData>) model.get("results");
		/*List<String> numericColumns = new ArrayList<String>();
		if (model.containsKey("numericcolumns"))
			numericColumns = (List<String>) model.get("numericcolumns");*/
		// BUILD DOC
		HSSFSheet sheet = workbook.createSheet(sheetName);
		sheet.setDefaultColumnWidth((short) 15);
		sheet.autoSizeColumn(1000000);
		
		
		HSSFCellStyle headerStyle = workbook.createCellStyle();
		HSSFFont headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontName(HSSFFont.FONT_ARIAL);
		headerFont.setFontHeightInPoints((short)11);
		headerStyle.setFont(headerFont);
		headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);		
		headerStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
		headerStyle.setWrapText(true);
		
		
		//headerStyle1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
		int currentRow = 0;
		short currentColumn = 0;
		
		HSSFRow headerRow = sheet.createRow(currentRow);
		for (String header : headers) {
			HSSFRichTextString text = new HSSFRichTextString(header);
			HSSFCell cell = headerRow.createCell(currentColumn);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(text);
			currentColumn++;
		}

		int r = 1;
		for (FinalData st : results) {
			int c = 0;
			Row row = sheet.createRow(r++);
			
			//adding TicketNumber To excel
			
			Cell ticketNum=row.createCell(c++);
			ticketNum.setCellValue(st.getTicketNumber());
			
			// adding pr_id to excel
			Cell id = row.createCell(c++);
			id.setCellValue(st.getPr_id());

			// adding pr_state to excel
			Cell prstate = row.createCell(c++);
			prstate.setCellValue(st.getPr_state());

		    //adding Author to excel
			Cell author = row.createCell(c++);
			author.setCellValue(st.getAuthor());
			
			//adding comment to excel
			Cell comment = row.createCell(c++);
			comment.setCellValue(st.getComment());
			comment.removeHyperlink();
			
			
	        //adding comment_Author to excel
			Cell commentauthor = row.createCell(c++);
			commentauthor.setCellValue(st.getComment_Author());
			
			//adding comment_date to excel
			Cell commentdate = row.createCell(c++);
			commentdate.setCellValue(st.getComment_Date());
			
			//adding barnch_Name to excel
			Cell branchName = row.createCell(c++);
			branchName.setCellValue(st.getBranch_Name());
	
			
			}
		//autoSize increment of column
		for(int i=0;i<8;i++) {
			sheet.autoSizeColumn(i);
			
		}

		}
	}


package structural.design.pattern;

import java.sql.Connection;

interface PdfReport {
	public abstract void generatePdfReport(Connection connection,String tableName);
}

interface ExcelReport {
	public abstract void generateExcelReport(Connection connection,String tableName);
}

interface HtmlReport {
	public abstract void generateHtmlReport(Connection connection,String tableName);
}

class PdfReportImpl implements PdfReport {

	@Override
	public void generatePdfReport(Connection connection, String tableName) {
		System.out.println("PDF report generation logic is here..");
	}
	
}

class ExcelReportImpl implements ExcelReport {

	@Override
	public void generateExcelReport(Connection connection, String tableName) {
		System.out.println("EXCEL report generation logic is here..");
	}
	
}

class HtmlReportImpl implements HtmlReport {

	@Override
	public void generateHtmlReport(Connection connection, String tableName) {
		System.out.println("HTML report generation logic is here..");
	}
	
}

class ReportFacade {
	
	private PdfReport pdfReport;
	private ExcelReport excelReport;
	private HtmlReport htmlReport;
	
	public ReportFacade() {
		pdfReport = new PdfReportImpl();
		excelReport = new ExcelReportImpl();
		htmlReport = new HtmlReportImpl();
	}
	
	public void generatePdfReport(Connection connection, String tableName) {
		pdfReport.generatePdfReport(connection, tableName);
	}
	
	public void generateExcelReport(Connection connection, String tableName) {
		excelReport.generateExcelReport(connection, tableName);
	}
	
	public void generateHtmlReport(Connection connection, String tableName) {
		htmlReport.generateHtmlReport(connection, tableName);
	}
}

public class FacadePattern {
	
	public static void main(String[] args) {
		Connection connection = null;
		String tableName = "employee_table";
		
		//without using Facade Pattern
		PdfReport pdfReport = new PdfReportImpl();
		pdfReport.generatePdfReport(connection, tableName);
		
		ExcelReport excelReport = new ExcelReportImpl();
		excelReport.generateExcelReport(connection, tableName);
		
		HtmlReport htmlReport = new HtmlReportImpl();
		htmlReport.generateHtmlReport(connection, tableName);
		
		System.out.println("---------------------------------------------------");
		
		//With Using Facade Pattern
		ReportFacade reportFacade = new ReportFacade();
		reportFacade.generatePdfReport(connection, tableName);
		reportFacade.generateExcelReport(connection, tableName);
		reportFacade.generateHtmlReport(connection, tableName);
	}

}

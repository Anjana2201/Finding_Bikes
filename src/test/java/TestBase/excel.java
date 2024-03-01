package TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle style;
	static String file="C:\\Users\\2303779\\OneDrive - Cognizant\\Desktop\\Hackathon_2303779\\Bikes\\test-data\\Book1.xlsx";
	
	public static void setcelldata(String Sheet,String text,int r,int c) throws IOException {
		fi=new FileInputStream(file);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(Sheet);
		if(ws.getRow(r) != null) {
	        row = ws.getRow(r);}
	    else {
	        row = ws.createRow(r);
	    }
		cell=row.createCell(c);
		cell.setCellValue(text);
		fo=new FileOutputStream(file);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}

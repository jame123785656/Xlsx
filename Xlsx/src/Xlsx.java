 import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

class ReadWriteExcelData {

@Test
void testReadData() throws IOException {
//Path of the excel file
FileInputStream fs = new FileInputStream("C:\\Users\\Administrator\\Desktop/DemoFile.xlsx");

//Creating a workbook
XSSFWorkbook workbook = new XSSFWorkbook(fs);

XSSFSheet sheet = workbook.getSheetAt(0);

System.out.println(sheet.getRow(0).getCell(0));

System.out.println(sheet.getRow(0).getCell(1));

System.out.println(sheet.getRow(0).getCell(2));

System.out.println(sheet.getRow(1).getCell(0));

System.out.println(sheet.getRow(1).getCell(1));

System.out.println(sheet.getRow(1).getCell(2));

workbook.close();
}
@Test
void testWriteData() throws IOException {

String path = "C:\\\\Users\\\\Administrator\\\\Desktop/DemoFile.xlsx";
FileInputStream fs = new FileInputStream(path);
Workbook wb = new XSSFWorkbook(fs);
Sheet sheet1 = wb.getSheetAt(0);
int lastRow = sheet1.getLastRowNum();
for (int i = 0; i <= lastRow; i++) {
Row row = sheet1.getRow(i);
Cell cell = row.createCell(2);

cell.setCellValue("WriteintoExcel");
}
FileOutputStream fos = new FileOutputStream(path);
wb.write(fos);
fos.close();
}

}

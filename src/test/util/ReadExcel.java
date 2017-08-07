package test.util;

import org.apache.poi.POITextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ReadExcel {


    /**
     * 读取office 2003 xls
     *
     * @param filePath
     */

    @SuppressWarnings({"unchecked", "deprecation"})

    public static void loadXls(String filePath) {

        try {

            InputStream input = new FileInputStream(filePath);

            POIFSFileSystem fs = new POIFSFileSystem(input);

            HSSFWorkbook wb = new HSSFWorkbook(fs);

            HSSFSheet sheet = wb.getSheetAt(0);

            // Iterate over each row in the sheet

            Iterator rows = sheet.rowIterator();

            while (rows.hasNext()) {

                HSSFRow row = (HSSFRow) rows.next();

                System.out.println("Row #" + row.getRowNum());

                // Iterate over each cell in the row and print out the cell"s

                // content

                Iterator cells = row.cellIterator();

                while (cells.hasNext()) {

                    HSSFCell cell = (HSSFCell) cells.next();

                    System.out.println("Cell #" + cell.getCellNum());

                    switch (cell.getCellType()) {

                        case HSSFCell.CELL_TYPE_NUMERIC:

                            System.out.println(cell.getNumericCellValue());

                            break;

                        case HSSFCell.CELL_TYPE_STRING:

                            System.out.println(cell.getStringCellValue());

                            break;

                        case HSSFCell.CELL_TYPE_BOOLEAN:

                            System.out.println(cell.getBooleanCellValue());

                            break;

                        case HSSFCell.CELL_TYPE_FORMULA:

                            System.out.println(cell.getCellFormula());

                            break;

                        default:

                            System.out.println("unsuported sell type");

                            break;

                    }

                }

            }

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

    /**
     * 读取xlsx文本
     *
     * @param filePath
     */

    public void loadXlsxText(String filePath) {

        File inputFile = new File(filePath);

        try {

            POITextExtractor extractor = ExtractorFactory.createExtractor(inputFile);

            System.out.println(extractor.getText());

        } catch (InvalidFormatException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (OpenXML4JException e) {

            e.printStackTrace();

        } catch (XmlException e) {

            e.printStackTrace();

        }

    }

    /**
     * 读取office 2007 xlsx
     *
     * @param filePath
     */

    public  static void loadXlsx(String filePath) {

        // 构造 XSSFWorkbook 对象，strPath 传入文件路径

        XSSFWorkbook xwb = null;

        try {

            xwb = new XSSFWorkbook(filePath);

        } catch (IOException e) {

            System.out.println("读取文件出错");

            e.printStackTrace();

        }

        // 读取第一章表格内容

        XSSFSheet sheet = xwb.getSheetAt(0);

        xwb.getSheetAt(1);

        // 定义 row、cell

        XSSFRow row;

        String cell;

        // 循环输出表格中的内容

        for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {

            row = sheet.getRow(i);

            for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {

                // 通过 row.getCell(j).toString() 获取单元格内容，

                cell = row.getCell(j).toString();

                System.out.print(cell + "/t");

            }

            System.out.println("");

        }

    }

    public static void main(String[] args) {
        //
        ReadExcel readExcel = new ReadExcel();

        readExcel.loadXlsx("D://temp//ewq.xlsx");

    }

}
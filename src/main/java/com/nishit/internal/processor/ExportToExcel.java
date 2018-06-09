package com.nishit.internal.processor;

import com.nishit.internal.Model.ExcelModel;
import com.nishit.internal.Model.OrderFieldModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class ExportToExcel {


    public static void export(ExcelModel model) {
        assert model.getDtoList().size()>0 : "bean cannot be empty";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(model.getSheetName());
        writetoExcelSheet(sheet,model.getDtoList());
        try {
            FileOutputStream outputStream = new FileOutputStream(model.getFilePath());
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writetoExcelSheet(XSSFSheet sheet, List<Object> dtoList) {
        int rowNum = 0;
        int colNum = 0;
        System.out.println("Creating excel");
        Row row=null;

        //updating header;
        PriorityQueue<OrderFieldModel> pq=ExcelDataProcessor.getHeaders(dtoList.get(0));
         row = sheet.createRow(rowNum++);
        updateCellValues(row, colNum, pq);

        for (Object object : dtoList) {
             row = sheet.createRow(rowNum++);


             pq = AnnotationDataHandler.processAnotations(object);
            updateCellValues(row, colNum, pq);
        }
    }

    private static void updateCellValues(Row row, int colNum,  PriorityQueue<OrderFieldModel> pq) {
        while (!pq.isEmpty()) {
            Object field = pq.poll().getObject();
            {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                } else if (field instanceof Double) {
                    cell.setCellValue((Double) field);
                } else if (field instanceof RichTextString) {
                    cell.setCellValue((RichTextString) field);
                } else if (field instanceof Date) {
                    cell.setCellValue((Date) field);
                } else if (field instanceof Boolean) {
                    cell.setCellValue((Boolean) field);
                }
            }
        }

    }

}

package com.nishit.external.Handler;

import com.nishit.internal.processor.ExportToExcel;
import com.nishit.internal.Model.ExcelModel;

import java.util.List;

public class ExportDataHandler {



   private ExcelModel excelModel;

    public ExportDataHandler(String filePath, List<Object> dtoList, String sheetName)
    {

        this.excelModel =new ExcelModel();
        this.excelModel.setFilePath(filePath);
        this.excelModel.setDtoList(dtoList);
        this.excelModel.setSheetName(sheetName);
    }



public boolean exportData()
{
    try
    {
        ExportToExcel.export(excelModel);
    }
    catch (Exception e)
    {
        return false;
    }
    return true;
}

}

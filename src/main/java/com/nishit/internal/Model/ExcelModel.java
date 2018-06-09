package com.nishit.internal.Model;

import java.util.List;

public class ExcelModel {
    private String filePath;
    private List<Object> dtoList;
    private String sheetName;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



    public String getSheetName() {
        return sheetName;
    }

    public List<Object> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<Object> dtoList) {
        this.dtoList = dtoList;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
}

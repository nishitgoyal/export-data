import com.nishit.external.Handler.ExportDataHandler;

import java.util.LinkedList;
import java.util.List;

public class TestFlow2 {

    public static void main(String args[])
    {
        Object dto1=new TestAnnotation2();
        ((TestAnnotation2) dto1).setA("hello1");
        ((TestAnnotation2) dto1).setB(20);
        ((TestAnnotation2) dto1).setC("hello12");


        Object dto2=new TestAnnotation2();
        ((TestAnnotation2) dto2).setA("hello2");
        ((TestAnnotation2) dto2).setB(40);
        ((TestAnnotation2) dto2).setC("hello21");

        List<Object> dtoList=new LinkedList<Object>();
        dtoList.add(dto1);
        dtoList.add(dto2);

        ExportDataHandler handler=new ExportDataHandler("//Users//n0g009t//myPersonalProjs//export-data//src//main//resources//test2.xlsx",dtoList,"hello");
        handler.exportData();
        // AnnotationDataHandler handler=new AnnotationDataHandler();
        // handler.processAnotations(dto);

    }
}


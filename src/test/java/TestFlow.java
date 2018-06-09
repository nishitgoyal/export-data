import com.nishit.external.Handler.ExportDataHandler;
import com.nishit.internal.processor.AnnotationDataHandler;

import java.util.LinkedList;
import java.util.List;

public class TestFlow {

    public static void main(String args[])
    {
        Object dto1=new TestAnnotation();
        ((TestAnnotation) dto1).setA(10);
        ((TestAnnotation) dto1).setB(20);
        ((TestAnnotation) dto1).setC(25);

        Object dto2=new TestAnnotation();
        ((TestAnnotation) dto2).setA(30);
        ((TestAnnotation) dto2).setB(50);
        ((TestAnnotation) dto2).setA(30);
        ((TestAnnotation) dto2).setC(55);

        List<Object> dtoList=new LinkedList<Object>();
        dtoList.add(dto1);
        dtoList.add(dto2);

        ExportDataHandler handler=new ExportDataHandler("//Users//n0g009t//myPersonalProjs//export-data//src//main//resources//test1.xlsx",dtoList,"hello");
        handler.exportData();
       // AnnotationDataHandler handler=new AnnotationDataHandler();
       // handler.processAnotations(dto);

    }
}

import com.nishit.external.Annotations.ColumnHeader;
import com.nishit.external.Annotations.ColumnOrder;

public class TestAnnotation2 {



    @ColumnHeader("abc")
    @ColumnOrder("2")
    private  String a;

    @ColumnHeader("cde")
    @ColumnOrder("1")
    private int b;


    @ColumnHeader("efg")
    @ColumnOrder("1")
    private String c;


    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }





    public void setA(String a) {
        this.a = a;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }



}

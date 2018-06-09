import com.nishit.external.Annotations.ColumnHeader;
import com.nishit.external.Annotations.ColumnOrder;

public class TestAnnotation {


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @ColumnHeader("abc")
    @ColumnOrder("2")
    private  int a;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @ColumnHeader("cde")
    @ColumnOrder("1")
    private int b;


    private int c;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}

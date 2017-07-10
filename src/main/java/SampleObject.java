import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chathura Widanage
 */
public class SampleObject implements Serializable {

    public String prop1 = "property1";
    public String prop2 = "property2";
    public String prop3 = "property3";
    public String prop4 = "property4";

    public List<SampleObject> children = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SampleObject that = (SampleObject) o;

        if (!prop1.equals(that.prop1)) return false;
        if (!prop2.equals(that.prop2)) return false;
        if (!prop3.equals(that.prop3)) return false;
        if (!prop4.equals(that.prop4)) return false;
        return children.equals(that.children);
    }

    @Override
    public int hashCode() {
        int result = prop1.hashCode();
        result = 31 * result + prop2.hashCode();
        result = 31 * result + prop3.hashCode();
        result = 31 * result + prop4.hashCode();
        result = 31 * result + children.hashCode();
        return result;
    }
}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Chathura Widanage
 */
public class SampleObject implements Serializable, Cloneable {

    public String prop1;
    public String prop2;
    public String prop3;
    public String prop4;

    public List<SampleObject> children;

    public SampleObject() {
        this.prop1 = UUID.randomUUID().toString();
        this.prop2 = UUID.randomUUID().toString();
        this.prop3 = UUID.randomUUID().toString();
        this.prop4 = UUID.randomUUID().toString();
        this.children = new ArrayList<>();
    }

    public SampleObject(boolean create){

    }

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SampleObject clone = (SampleObject) super.clone();
        clone.children = new ArrayList<>();
        for (SampleObject child : this.children) {
            clone.children.add((SampleObject) child.clone());
        }
        return clone;
    }
}

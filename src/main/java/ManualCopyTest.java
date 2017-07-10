/**
 * @author Chathura Widanage
 */
public class ManualCopyTest extends AbstractTest<SampleObject> {

    public SampleObject copy(SampleObject sampleObject) {
        SampleObject copy = new SampleObject();
        copy.prop1 = sampleObject.prop1;
        copy.prop2 = sampleObject.prop2;
        copy.prop3 = sampleObject.prop3;
        copy.prop4 = sampleObject.prop4;
        sampleObject.children.forEach(child -> {
            copy.children.add(this.copy(child));
        });
        return copy;
    }

    @Override
    public byte[] serialize(SampleObject sampleObject) throws Exception {
        return new byte[0];
    }

    @Override
    public SampleObject deserialize(byte[] data) throws Exception {
        return null;
    }
}

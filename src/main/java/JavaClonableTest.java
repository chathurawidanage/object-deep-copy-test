public class JavaClonableTest extends AbstractTest<SampleObject> {

    @Override
    public SampleObject copy(SampleObject sampleObject) throws Exception {
        return (SampleObject) sampleObject.clone();
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

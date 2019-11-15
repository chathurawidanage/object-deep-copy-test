import org.apache.commons.lang3.SerializationUtils;

public class ApacheCommonsTest extends AbstractTest<SampleObject> {
    @Override
    public SampleObject copy(SampleObject sampleObject) throws Exception {
        return deserialize(serialize(sampleObject));
    }

    @Override
    public byte[] serialize(SampleObject sampleObject) throws Exception {
        return SerializationUtils.serialize(sampleObject);
    }

    @Override
    public SampleObject deserialize(byte[] data) throws Exception {
        return SerializationUtils.deserialize(data);
    }
}

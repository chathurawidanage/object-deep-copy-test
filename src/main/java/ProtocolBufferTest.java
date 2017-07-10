import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author Chathura Widanage
 */
public class ProtocolBufferTest extends AbstractTest<SampleObjectProto.SampleObject> {

    public byte[] serialize(SampleObjectProto.SampleObject sampleObject) {
        return sampleObject.toByteArray();
    }

    public SampleObjectProto.SampleObject deserialize(byte[] data) throws InvalidProtocolBufferException {
        return SampleObjectProto.SampleObject.parseFrom(data);
    }

    @Override
    public SampleObjectProto.SampleObject copy(SampleObjectProto.SampleObject sampleObject) throws Exception {
        return deserialize(serialize(sampleObject));
    }
}

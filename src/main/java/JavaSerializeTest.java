import java.io.*;

/**
 * @author Chathura Widanage
 */
public class JavaSerializeTest extends AbstractTest<SampleObject> {

    public byte[] serialize(SampleObject sampleObject) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(sampleObject);
        out.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public SampleObject deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream in = new ObjectInputStream(byteArrayInputStream);
        return (SampleObject) in.readObject();
    }


    public SampleObject copy(SampleObject sampleObject) throws IOException, ClassNotFoundException {
        return deserialize(serialize(sampleObject));
    }
}

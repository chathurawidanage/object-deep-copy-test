import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class CustomPackingTest extends AbstractTest<SampleObject> {

    @Override
    public SampleObject copy(SampleObject sampleObject) throws Exception {
        return deserialize(serialize(sampleObject));
    }

    private void writeStringToBuffer(String str, ByteBuffer buffer) {
        byte[] bytes = str.getBytes();
        buffer.putInt(bytes.length);
        buffer.put(bytes);
    }

    private String readStringFromBuffer(ByteBuffer byteBuffer) {
        int length = byteBuffer.getInt();
        byte[] str = new byte[length];
        byteBuffer.get(str);
        return new String(str);
    }

    private void writeListToBuffer(List<SampleObject> list, ByteBuffer byteBuffer) throws Exception {
        byteBuffer.putInt(list.size());
        for (SampleObject sampleObject : list) {
            byte[] serialize = this.serialize(sampleObject);
            byteBuffer.putInt(serialize.length);
            byteBuffer.put(serialize);
        }
    }

    private List<SampleObject> readListFromBuffer(ByteBuffer byteBuffer) throws Exception {
        List<SampleObject> list = new ArrayList<>();
        int length = byteBuffer.getInt();
        for (int i = 0; i < length; i++) {
            int objLength = byteBuffer.getInt();
            byte[] objectBytes = new byte[objLength];
            byteBuffer.get(objectBytes);
            list.add(deserialize(objectBytes));
        }
        return list;
    }

    final Queue<ByteBuffer> bufferQueue = new LinkedList<>();

    {
        for (int i = 0; i < 100; i++) {
            bufferQueue.add(ByteBuffer.allocate(1024 * 1024));
        }
    }

    @Override
    public byte[] serialize(SampleObject sampleObject) throws Exception {
        ByteBuffer buff = bufferQueue.poll();
        this.writeStringToBuffer(sampleObject.prop1, buff);
        this.writeStringToBuffer(sampleObject.prop2, buff);
        this.writeStringToBuffer(sampleObject.prop3, buff);
        this.writeStringToBuffer(sampleObject.prop4, buff);
        this.writeListToBuffer(sampleObject.children, buff);
        byte[] b = new byte[buff.position()];
        buff.flip();
        buff.get(b);
        buff.clear();
        bufferQueue.add(buff);
        return b;
    }

    @Override
    public SampleObject deserialize(byte[] data) throws Exception {
        SampleObject sampleObject = new SampleObject(false);
        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        sampleObject.prop1 = readStringFromBuffer(byteBuffer);
        sampleObject.prop2 = readStringFromBuffer(byteBuffer);
        sampleObject.prop3 = readStringFromBuffer(byteBuffer);
        sampleObject.prop4 = readStringFromBuffer(byteBuffer);
        sampleObject.children = readListFromBuffer(byteBuffer);
        return sampleObject;
    }
}

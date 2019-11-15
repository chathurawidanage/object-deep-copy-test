import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.util.LinkedList;
import java.util.Queue;

public class KryoTest extends AbstractTest<SampleObject> {

    private Kryo kryo = new Kryo();

    public KryoTest() {
        this.kryo = new Kryo();
        this.kryo.register(SampleObject.class);
    }

    @Override
    public SampleObject copy(SampleObject sampleObject) throws Exception {
        return this.kryo.copy(sampleObject);
    }

    private Queue<Output> outputQueue = new LinkedList<>();

    {
        for (int i = 0; i < 100; i++) {
            outputQueue.add(new Output(1024 * 1024, -1));
        }
    }

    @Override
    public byte[] serialize(SampleObject sampleObject) throws Exception {
        Output output = outputQueue.poll();
        kryo.writeObject(output, sampleObject);
        byte[] buff = output.getBuffer();
        output.clear();
        outputQueue.add(output);
        return buff;
    }

    @Override
    public SampleObject deserialize(byte[] data) throws Exception {
        Input input = new Input();
        input.setBuffer(data);
        return kryo.readObject(input, SampleObject.class);
    }
}

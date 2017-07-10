import java.util.ArrayList;
import java.util.List;

/**
 * @author Chathura Widanage
 */
public class Test {
    public static void main(String[] args) throws Exception {
        SampleCreator sampleCreator = new SampleCreator(5);
        List<SampleObject> sampleObjectList = new ArrayList<>();
        List<SampleObjectProto.SampleObject> sampleProtoObjectList = new ArrayList<>();
        System.out.println("Generating sample");
        for (int i = 0; i < 1500; i++) {
            SampleObject sample = sampleCreator.createSample();
            sampleObjectList.add(sample);
            SampleObjectProto.SampleObject sampleMirror = sampleCreator.mirrorToProtocolBuffer(sample);
            sampleProtoObjectList.add(sampleMirror);
        }
        System.out.println("Sample generated");

        System.out.println("\nStarting Speed Test\n-----------------\n");
        JSONTest jsonTest = new JSONTest();
        double averageTime = TestExecutor.speedTest(jsonTest, sampleObjectList);
        System.out.println("JSON Copy time : " + averageTime);

        ManualCopyTest manualCopyTest = new ManualCopyTest();
        averageTime = TestExecutor.speedTest(manualCopyTest, sampleObjectList);
        System.out.println("Manual Copy time : " + averageTime);

        JavaSerializeTest javaSerializeTest = new JavaSerializeTest();
        averageTime = TestExecutor.speedTest(javaSerializeTest, sampleObjectList);
        System.out.println("Java Serialization Copy time : " + averageTime);

        ProtocolBufferTest protocolBufferTest = new ProtocolBufferTest();
        averageTime = TestExecutor.speedTest(protocolBufferTest, sampleProtoObjectList);
        System.out.println("Protocol buffer Copy time : " + averageTime);

        System.out.println("\nStarting Space Test\n-----------------\n");

        long totalSpace = TestExecutor.spaceTest(jsonTest, sampleObjectList);
        double sk = Math.pow(10, 6);
        System.out.println("JSON space(MB) : " + totalSpace / sk);

        totalSpace = TestExecutor.spaceTest(javaSerializeTest, sampleObjectList);
        System.out.println("Java  Serialization space(MB) : " + totalSpace/sk);

        totalSpace = TestExecutor.spaceTest(protocolBufferTest, sampleProtoObjectList);
        System.out.println("Protocol buffer space(MB) : " + totalSpace/sk);
    }
}

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
        for (int i = 0; i < 15; i++) {
            SampleObject sample = sampleCreator.createSample();
            sampleObjectList.add(sample);
            SampleObjectProto.SampleObject sampleMirror = sampleCreator.mirrorToProtocolBuffer(sample);
            sampleProtoObjectList.add(sampleMirror);
        }
        System.out.println("Sample generated");

        System.out.println("\nStarting Speed Test\n-----------------\n");
        JSONTest jsonTest = new JSONTest();
        double averageTime = TestExecutor.speedTest(jsonTest, sampleObjectList);
        System.out.println("JSON Copy avg time(ms) : " + averageTime);

        ManualCopyTest manualCopyTest = new ManualCopyTest();
        averageTime = TestExecutor.speedTest(manualCopyTest, sampleObjectList);
        System.out.println("Manual Copy avg time(ms) : " + averageTime);

        JavaClonableTest javaClonableTest = new JavaClonableTest();
        averageTime = TestExecutor.speedTest(javaClonableTest, sampleObjectList);
        System.out.println("Java Clonable avg time(ms) : " + averageTime);

        JavaSerializeTest javaSerializeTest = new JavaSerializeTest();
        averageTime = TestExecutor.speedTest(javaSerializeTest, sampleObjectList);
        System.out.println("Java Serialization Copy avg time(ms) : " + averageTime);

        ProtocolBufferTest protocolBufferTest = new ProtocolBufferTest();
        averageTime = TestExecutor.speedTest(protocolBufferTest, sampleProtoObjectList);
        System.out.println("Protocol buffer Copy avg time(ms) : " + averageTime);

        ApacheCommonsTest apacheCommonsTest = new ApacheCommonsTest();
        averageTime = TestExecutor.speedTest(apacheCommonsTest, sampleObjectList);
        System.out.println("Apache Commons Copy avg time(ms) : " + averageTime);

        KryoTest kryoTest = new KryoTest();
        averageTime = TestExecutor.speedTest(kryoTest, sampleObjectList);
        System.out.println("Kryo Copy avg time(ms) : " + averageTime);

        CustomPackingTest customPackingTest = new CustomPackingTest();
        averageTime = TestExecutor.speedTest(customPackingTest, sampleObjectList);
        System.out.println("Custom Packing avg time(ms) : " + averageTime);


        System.out.println("\nStarting Space Test\n-----------------\n");

        long totalSpace = TestExecutor.spaceTest(jsonTest, sampleObjectList);
        double sk = Math.pow(10, 6);
        System.out.println("JSON space(MB) : " + totalSpace / sk);

        totalSpace = TestExecutor.spaceTest(javaSerializeTest, sampleObjectList);
        System.out.println("Java  Serialization space(MB) : " + totalSpace / sk);

        totalSpace = TestExecutor.spaceTest(protocolBufferTest, sampleProtoObjectList);
        System.out.println("Protocol buffer space(MB) : " + totalSpace / sk);

        totalSpace = TestExecutor.spaceTest(apacheCommonsTest, sampleObjectList);
        System.out.println("Apache commons space(MB) : " + totalSpace / sk);

        totalSpace = TestExecutor.spaceTest(kryoTest, sampleObjectList);
        System.out.println("Kryo space(MB) : " + totalSpace / sk);

        totalSpace = TestExecutor.spaceTest(customPackingTest, sampleObjectList);
        System.out.println("Custom Packing space(MB) : " + totalSpace / sk);
    }
}

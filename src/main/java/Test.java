import java.util.ArrayList;
import java.util.List;

/**
 * @author Chathura Widanage
 */
public class Test {
    public static void main(String[] args) throws Exception {
        SampleCreator sampleCreator = new SampleCreator(5);
        List<SampleObject> sampleObjectList = new ArrayList<>();
        System.out.println("Generating sample");
        for (int i = 0; i < 10000; i++) {
            sampleObjectList.add(sampleCreator.createSample());
        }
        System.out.println("Sample generated");

        JSONTest jsonTest = new JSONTest();
        double averageTime = TestExecutor.test(jsonTest, sampleObjectList);
        System.out.println("JSON Copy time : " + averageTime);

        ManualCopyTest manualCopyTest = new ManualCopyTest();
        averageTime = TestExecutor.test(manualCopyTest, sampleObjectList);
        System.out.println("Manual Copy time : " + averageTime);

        JavaSerializeTest javaSerializeTest = new JavaSerializeTest();
        averageTime = TestExecutor.test(javaSerializeTest, sampleObjectList);
        System.out.println("Java Serialize Copy time : " + averageTime);
    }
}

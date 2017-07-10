import java.util.List;

/**
 * @author Chathura Widanage
 */
public class TestExecutor {
    public static double test(AbstractTest abstractTest, List<SampleObject> sampleObjectList) throws Exception {
        double totalTime = 0;
        for (SampleObject so : sampleObjectList) {
            double t1 = System.currentTimeMillis();
            SampleObject jsonCopy = abstractTest.copy(so);
            double t2 = System.currentTimeMillis();
            totalTime += (t2 - t1);
            if (!so.equals(jsonCopy)) {
                System.out.println("Invalid copy");
                System.exit(0);
            }
        }
        return totalTime / sampleObjectList.size();
    }
}

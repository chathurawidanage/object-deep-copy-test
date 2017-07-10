import java.util.List;

/**
 * @author Chathura Widanage
 */
public class TestExecutor {
    public static double speedTest(AbstractTest abstractTest, List sampleObjectList) throws Exception {
        double totalTime = 0;
        for (Object so : sampleObjectList) {
            double t1 = System.currentTimeMillis();
            Object copy = abstractTest.copy(so);
            double t2 = System.currentTimeMillis();
            totalTime += (t2 - t1);
            if (!so.equals(copy)) {
                System.out.println("Invalid copy");
                System.exit(0);
            }
        }
        return totalTime / sampleObjectList.size();
    }

    public static long spaceTest(AbstractTest abstractTest, List sampleObjectList) throws Exception {
        long totalSize = 0;
        for (Object so : sampleObjectList) {
            totalSize += abstractTest.serialize(so).length;
        }
        return totalSize;
    }
}

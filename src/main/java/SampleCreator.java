import java.util.Random;

/**
 * @author Chathura Widanage
 */
public class SampleCreator {
    private int level;
    private Random random = new Random();

    public SampleCreator(int level) {
        this.level = level;
    }

    public SampleObject createSample() {
        SampleObject sampleObject = new SampleObject();
        this.attachChildren(sampleObject, 0);
        return sampleObject;
    }

    public void attachChildren(SampleObject sampleObject, int level) {
        if (this.level == level) {
            return;
        }
        int i = random.nextInt(10);
        for (int j = 0; j < i; j++) {
            SampleObject child = new SampleObject();
            attachChildren(child, level + 1);
            sampleObject.children.add(child);
        }
    }
}

import java.util.Random;
import java.util.UUID;

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

    public SampleObjectProto.SampleObject mirrorToProtocolBuffer(SampleObject sampleObject) {
        SampleObjectProto.SampleObject.Builder emptyObject = createEmptyObject();
        doRecursiveMirror(sampleObject, emptyObject);
        return emptyObject.build();
    }

    private void doRecursiveMirror(SampleObject sampleObject, SampleObjectProto.SampleObject.Builder mirrored) {
        for (int i = 0; i < sampleObject.children.size(); i++) {
            SampleObject child = sampleObject.children.get(i);
            SampleObjectProto.SampleObject.Builder mirroredChild = createEmptyObject();
            doRecursiveMirror(child, mirroredChild);
            mirrored.addChildren(i, mirroredChild.build());
        }
    }

    private SampleObjectProto.SampleObject.Builder createEmptyObject() {
        return SampleObjectProto.SampleObject
                .newBuilder()
                .setProp1(UUID.randomUUID().toString())
                .setProp2(UUID.randomUUID().toString())
                .setProp3(UUID.randomUUID().toString())
                .setProp4(UUID.randomUUID().toString());
    }
}

/**
 * @author Chathura Widanage
 */
public abstract class AbstractTest<T extends Object> {
    public abstract T copy(T sampleObject) throws Exception;

    public abstract byte[] serialize(T sampleObject) throws Exception;

    public abstract T deserialize(byte[] data) throws Exception;
}

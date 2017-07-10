import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Chathura Widanage
 */
public class JSONTest extends AbstractTest<SampleObject> {

    private ObjectMapper objectMapper = new ObjectMapper();

    public byte[] serialize(SampleObject sampleObject) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(sampleObject);
    }

    public SampleObject deserialize(byte[] data) throws IOException {
        return objectMapper.readValue(data, SampleObject.class);
    }

    public SampleObject copy(SampleObject sampleObject) throws IOException {
        return deserialize(serialize(sampleObject));
    }
}

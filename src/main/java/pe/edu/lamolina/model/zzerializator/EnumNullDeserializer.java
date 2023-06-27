package pe.edu.lamolina.model.zzerializator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

public class EnumNullDeserializer extends StdDeserializer<Enum> {

    public EnumNullDeserializer() {
        this(null);
    }

    public EnumNullDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Enum deserialize(
            JsonParser jsonparser, DeserializationContext context)
            throws IOException {

        return null;
    }

}

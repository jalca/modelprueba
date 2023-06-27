package pe.edu.lamolina.model.zzerializator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import org.springframework.util.StringUtils;
import pe.edu.lamolina.model.enums.TipoCicloEnum;

public class TipoCicloEnumDeserializer extends StdDeserializer<TipoCicloEnum> {

    public TipoCicloEnumDeserializer() {
        this(null);
    }

    public TipoCicloEnumDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TipoCicloEnum deserialize(
            JsonParser jsonparser, DeserializationContext context)
            throws IOException {

        String info = jsonparser.getText();
        if (StringUtils.isEmpty(info)) {
            return null;
        }
        try {
            return TipoCicloEnum.valueOf(info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

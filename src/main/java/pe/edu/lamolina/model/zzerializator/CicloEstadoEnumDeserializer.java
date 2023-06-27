package pe.edu.lamolina.model.zzerializator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import org.springframework.util.StringUtils;
import pe.edu.lamolina.model.enums.CicloAcademicoEstadoEnum;

public class CicloEstadoEnumDeserializer extends StdDeserializer<CicloAcademicoEstadoEnum> {

    public CicloEstadoEnumDeserializer() {
        this(null);
    }

    public CicloEstadoEnumDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public CicloAcademicoEstadoEnum deserialize(
            JsonParser jsonparser, DeserializationContext context)
            throws IOException {

        String info = jsonparser.getText();
        if (StringUtils.isEmpty(info)) {
            return null;
        }
        try {
            return CicloAcademicoEstadoEnum.get(info);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

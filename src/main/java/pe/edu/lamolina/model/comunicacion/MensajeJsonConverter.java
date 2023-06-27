package pe.edu.lamolina.model.comunicacion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import javax.persistence.AttributeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MensajeJsonConverter implements AttributeConverter<List<Mensaje>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String convertToDatabaseColumn(List<Mensaje> data) {
        try {
            return objectMapper.writeValueAsString(data);
            
        } catch (JsonProcessingException ex) {
            logger.error("Unexpected JSON serializing");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Mensaje> convertToEntityAttribute(String data) {
        try {

            return objectMapper.readValue(data, new TypeReference<List<Mensaje>>() {});

        } catch (IOException ex) {
            logger.error("Unexpected IOEx deserializing JSON: {}", data);
            ex.printStackTrace();
            return null;
        }
    }

}

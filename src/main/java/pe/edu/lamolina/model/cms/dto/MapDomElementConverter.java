package pe.edu.lamolina.model.cms.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import javax.persistence.AttributeConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapDomElementConverter implements AttributeConverter<Map<String, DomElement>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, DomElement> mapDom) {

        try {
            return objectMapper.writeValueAsString(mapDom);

        } catch (JsonProcessingException ex) {
            log.error("Unexpected serializing CMS-ElementoDOM");
            return "";
        }

    }

    @Override
    public Map<String, DomElement> convertToEntityAttribute(String dbData) {
        try {

            return objectMapper.readValue(dbData, new TypeReference<Map<String, DomElement>>() {
            });

        } catch (IOException ex) {
            log.error("Unexpected Deserializing CMS-ElementoDOM: {}", dbData);
            return null;
        }
    }

}

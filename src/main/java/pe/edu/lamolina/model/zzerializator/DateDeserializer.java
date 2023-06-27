package pe.edu.lamolina.model.zzerializator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class DateDeserializer extends StdDeserializer<Date> {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DateDeserializer() {
        this(null);
    }

    public DateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(
            JsonParser jsonparser, DeserializationContext context)
            throws IOException {

        String date = jsonparser.getText();
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        Date dateResult = null;

        List<SimpleDateFormat> formatos = Arrays.asList(formatter, formatter2, formatter3, formatter4);
        for (SimpleDateFormat formato : formatos) {
            try {
                dateResult = formato.parse(date);
                break;
            } catch (ParseException e) {
                dateResult = null;
            }
        }
        if (dateResult == null) {
            throw new RuntimeException(String.format("Error Date, %s ", date));
        }
        return dateResult;
    }

}

package pe.edu.lamolina.model.comedor.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.json.JaneHelper;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Getter
@Setter
@NoArgsConstructor
public class ResumenAtencionComedor {

    private List<ResumenAtencionServicio> resumenes;
    private ResumenAtencionServicio presentes;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date fecha;

    public ResumenAtencionComedor(Date fecha) {
        this.fecha = fecha;
        this.resumenes = new ArrayList();
    }

    public ObjectNode toJson() {
        ObjectNode node = JaneHelper
                .from(this).only("fecha")
                .join("presentes")
                .json();

        ArrayNode array = JaneHelper.from(resumenes).array();
        node.set("resumenes", array);

        return node;
    }

    @Override
    public String toString() {
        return this.toJson().toString();
    }
}

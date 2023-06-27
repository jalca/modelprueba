package pe.edu.lamolina.model.cms.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

@Getter
@Setter
public class DomElement implements Serializable {

    private String id;

    private String titulo;

    private String codigo;

    private String html;

    private String target;

    private String link;

    private String clases;

    private String miniatura;

    private String tipo;

    private Date fechaPublicacion;

    private Date fechaEvento;

    private List<DomElement> items;

    public List<DomElement> getItems() {
        if (CollectionUtils.isEmpty(items)) {
            items = new ArrayList();
        }

        return items;
    }

}

package pe.edu.lamolina.model.inscripcion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "sip_contenido_carta_variable")
public class ContenidoCartaVariable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "ejemplo")
    private String ejemplo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contenido")
    private ContenidoCarta contenidoCarta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_variable")
    private ContenidoVariable contenidoVariable;

    public ContenidoCartaVariable() {
    }

    public ContenidoCartaVariable(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContenidoCarta getContenidoCarta() {
        return contenidoCarta;
    }

    public void setContenidoCarta(ContenidoCarta contenidoCarta) {
        this.contenidoCarta = contenidoCarta;
    }

    public ContenidoVariable getContenidoVariable() {
        return contenidoVariable;
    }

    public void setContenidoVariable(ContenidoVariable contenidoVariable) {
        this.contenidoVariable = contenidoVariable;
    }

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }

}


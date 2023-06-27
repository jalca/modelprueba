package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import pe.edu.lamolina.model.enums.TipoMiembroComiteEnum;
import pe.edu.lamolina.model.general.Persona;

@Entity
@Table(name = "epg_miembro_jurado_tesis")
public class MiembroJuradoTesis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jurado_tesis")
    private JuradoTesis juradoTesis;

    public MiembroJuradoTesis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public JuradoTesis getJuradoTesis() {
        return juradoTesis;
    }

    public void setJuradoTesis(JuradoTesis juradoTesis) {
        this.juradoTesis = juradoTesis;
    }

    public TipoMiembroComiteEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoMiembroComiteEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipo(TipoMiembroComiteEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}

package pe.edu.lamolina.model.social;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Strings;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoGradoEnum;

@Entity
@Table(name = "soc_disciplina_academica")
public class DisciplinaAcademica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "tipo")
    private String tipo;

    public DisciplinaAcademica() {
    }

    public DisciplinaAcademica(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoGradoEnum getTipoGradoEnum() {
        if (Strings.isNullOrEmpty(this.tipo)) {
            return null;
        }
        return TipoGradoEnum.valueOf(this.tipo);
    }

    @JsonIgnore
    public void setTipoGradoEnum(TipoGradoEnum tipoGradoEnum) {
        if (tipoGradoEnum == null) {
            return;
        }
        this.tipo = tipoGradoEnum.name();
    }

}

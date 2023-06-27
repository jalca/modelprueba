package pe.edu.lamolina.model.auditoria;

import pe.edu.lamolina.model.academico.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import static pe.edu.lamolina.model.constantines.GlobalConstantine.SCHEMA_AUDITOR;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Data
@Table(name = "aud_clonar_ciclo_nivelacion", catalog = SCHEMA_AUDITOR)
public class ClonarCicloNivelacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_origen")
    private CicloAcademico cicloOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_destino")
    private CicloAcademico cicloDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public ClonarCicloNivelacion() {
        this.fecha = new Date();
    }

    public ClonarCicloNivelacion(Long id) {
        this.id = id;
    }

}

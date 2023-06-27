package pe.edu.lamolina.model.log;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Data;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Data
@Entity
@Table(name = "log_usuario_programacion_logger")
public class UsuarioProgramacionLogger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario user;

    @Column(name = "id_docente")
    private Long docente;

    @Column(name = "id_seccion")
    private Long seccion;

    @Column(name = "id_grupo_seccion")
    private Long grupoSeccion;

    @Column(name = "id_docente_seccion")
    private Long docenteSeccion;

    @Column(name = "id_grupo_horas")
    private Long grupoHoras;

    @Column(name = "id_aula")
    private Long aula;

    public UsuarioProgramacionLogger() {
    }

    public UsuarioProgramacionLogger(Long id) {
        this.id = id;
    }

    public UsuarioProgramacionLogger(Usuario usuario) {
        this.fecha=new Date();
        this.user=usuario;
    }

}

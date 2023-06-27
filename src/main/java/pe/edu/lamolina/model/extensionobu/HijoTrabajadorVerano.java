package pe.edu.lamolina.model.extensionobu;

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
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.socioeconomico.VinculoFamiliar;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "extn_hijo_trabajador_verano")
public class HijoTrabajadorVerano implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_archivo")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaArchivo;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @JoinColumn(name = "id_persona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;

    @JoinColumn(name = "id_vinculo_familiar")
    @ManyToOne(fetch = FetchType.LAZY)
    private VinculoFamiliar vinculoFamiliar;

    @JoinColumn(name = "id_persona_trabajador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona personaTrabajador;

    @JoinColumn(name = "id_ciclo_academico")
    @ManyToOne(fetch = FetchType.LAZY)
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo")
    private Archivo archivo;

    @JoinColumn(name = "id_user_archivo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioArchivo;

    @JoinColumn(name = "id_user_registro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioRegistro;

    public HijoTrabajadorVerano(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}

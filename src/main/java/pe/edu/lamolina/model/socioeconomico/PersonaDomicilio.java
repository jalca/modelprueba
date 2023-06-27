package pe.edu.lamolina.model.socioeconomico;

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
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.general.Pais;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.Ubicacion;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "isec_persona_domicilio")
public class PersonaDomicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "es_residente_lima")
    private Boolean esResidenteLima;

    @Column(name = "direccion_lima")
    private String direccionLima;

    @Column(name = "direccion_otro")
    private String direccionOtro;

    @Column(name = "coordenada_lima")
    private String coordenadaLima;

    @Column(name = "coordenada_otro")
    private String coordenadaOtro;

    @Column(name = "telefono_lima")
    private String telefonoLima;

    @Column(name = "telefono_otro")
    private String telefonoOtro;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_lima")
    private Ubicacion ubicacionLima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ubicacion_otro")
    private Ubicacion ubicacionOtro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_otro")
    private Pais paisOtro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_foto_mapa_domicilio_lima")
    private Archivo fotoMapaDomicilioLima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_foto_mapa_domicilio_otro")
    private Archivo fotoMapaDomicilioOtro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_foto_fachada_domicilio_lima")
    private Archivo fotoFachadaDomicilioLima;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_foto_fachada_domicilio_otro")
    private Archivo fotoFachadaDomicilioOtro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_modificacion")
    private Usuario userModificacion;

    public PersonaDomicilio() {
    }

    public PersonaDomicilio(Object id) {
        this.id = TypesUtil.getLong(id);
    }

}

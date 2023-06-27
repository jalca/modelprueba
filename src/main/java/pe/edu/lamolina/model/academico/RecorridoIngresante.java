package pe.edu.lamolina.model.academico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.RecorridoIngresanteEstadoEnum;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.inscripcion.TurnoEntrevistaObuae;
import pe.edu.lamolina.model.medico.HistoriaLaboratorio;
import pe.edu.lamolina.model.seguridad.Usuario;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "aca_recorrido_ingresante")
public class RecorridoIngresante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "numero_atencion")
    private Integer numeroAtencion;

    @Column(name = "total_actividades")
    private Integer totalActividades;

    @Column(name = "actividades_postergadas")
    private Integer actividadesPostergadas;

    @Column(name = "actividades_ejecutadas")
    private Integer actividadesEjecutadas;

    @Column(name = "numero_muestra_sangre")
    private Long numeroMuestraSangre;

    @Column(name = "error_certificado_medico")
    private String errorCertificadoMedico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciclo_academico")
    private CicloAcademico cicloAcademico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turno_entrevista_obuae")
    private TurnoEntrevistaObuae turnoEntrevistaObuae;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_constancia_medica")
    private Archivo constanciaMedica;

    @OneToMany(mappedBy = "recorridoIngresante", fetch = FetchType.LAZY)
    private List<ActividadIngresante> actividadIngresante;

    @Transient
    private HistoriaLaboratorio laboratorio;
    @Transient
    private Usuario usuario;
    @Transient
    private Boolean tieneRiesgo;

    public RecorridoIngresante(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public RecorridoIngresanteEstadoEnum getEstadoEnum() {
        return estado != null ? RecorridoIngresanteEstadoEnum.valueOf(estado) : null;
    }

    @JsonIgnore
    public void setEstadoEnum(RecorridoIngresanteEstadoEnum estadoEnum) {
        if (estadoEnum == null) {
            return;
        }
        this.estado = estadoEnum.name();
    }

    public static class CompareTurno implements Comparator<RecorridoIngresante> {

        @Override
        public int compare(RecorridoIngresante s1, RecorridoIngresante s2) {
            return s1.getNumeroAtencion().compareTo(s2.getNumeroAtencion());
        }
    }

    public static class CompareAtencion implements Comparator<RecorridoIngresante> {

        @Override
        public int compare(RecorridoIngresante s1, RecorridoIngresante s2) {
            return s1.getLaboratorio().getNumeroMuestra().compareTo(s2.getLaboratorio().getNumeroMuestra());
        }
    }

    public static class CompareNombres implements Comparator<RecorridoIngresante> {

        @Override
        public int compare(RecorridoIngresante s1, RecorridoIngresante s2) {
            return s1.getAlumno().getPersona().getApellidosNombres().compareTo(s2.getAlumno().getPersona().getApellidosNombres());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RecorridoIngresante other = (RecorridoIngresante) obj;
        if (this.id.compareTo(other.id) != 0) {
            return false;
        }
        return true;
    }

}

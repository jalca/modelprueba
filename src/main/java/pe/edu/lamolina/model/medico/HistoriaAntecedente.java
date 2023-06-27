package pe.edu.lamolina.model.medico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zelper.util.ModelUtils;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "med_historia_antecedente")
public class HistoriaAntecedente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fue_operado")
    private Boolean fueOperado;

    @Column(name = "operacion")
    private String operacion;

    @Column(name = "lugar_operacion")
    private String lugarOperacion;

    @Column(name = "fecha_operacion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaOperacion;

    @Column(name = "toma_medicamento")
    private Boolean tomaMedicamento;

    @Column(name = "medicamento")
    private String medicamento;

    @Column(name = "alergias_medicamentosas")
    private String alergiasMedicamentosas;

    @Column(name = "tuvo_tratamiento_psicologico")
    private Boolean tuvoTratamientoPsicologico;

    @Column(name = "tuvo_tratamiento_psiquiatrico")
    private Boolean tuvoTratamientoPsiquiatrico;

    @Column(name = "fecha_psicologico")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPsicologico;

    @Column(name = "fecha_psiquiatrico")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPsiquiatrico;

    @Column(name = "duracion_tratamiento_psicologico")
    private String duracionTratamientoPsicologico;

    @Column(name = "duracion_tratamiento_psiquiatrico")
    private String duracionTratamientoPsiquiatrico;

    @Column(name = "diagnostico_tratamiento_psiquiatrico")
    private String diagnosticoTratamientoPsiquiatrico;

    @Column(name = "diagnostico_tratamiento_psicologico")
    private String diagnosticoTratamientoPsicologico;

    @Column(name = "tuvo_rubeola")
    private Boolean tuvoRubeola;

    @Column(name = "tuvo_sarampion")
    private Boolean tuvoSarampion;

    @Column(name = "tuvo_varicela")
    private Boolean tuvoVaricela;

    @Column(name = "tuvo_paperas")
    private Boolean tuvoPaperas;

    @Column(name = "tuvo_vacuna")
    private Boolean tuvoVacuna;

    @Column(name = "discapacidad")
    private String discapacidad;

    @Column(name = "tiene_carne_discapacidad")
    private Boolean tieneCarneDiscapacidad;

    @Column(name = "tiene_certificado_discapacidad")
    private Boolean tieneCertificadoDiscapacidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historia_clinica")
    private HistoriaClinica historiaClinica;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @Column(name = "tiene_tratamiento")
    private Boolean tieneTratamiento;

    @Column(name = "tiene_operacion")
    private Boolean tieneOperacion;

    @Column(name = "tiene_familiar_psiquiatrico")
    private Boolean tieneFamiliarPsiquiatrico;

    @Column(name = "tiene_habito_estudio")
    private Boolean tieneHabitoEstudio;

    @Column(name = "tiene_lugar_estudio")
    private Boolean tieneLugarEstudio;

    @Column(name = "tiene_alergia")
    private Boolean tieneAlergia;

    @Column(name = "tiene_enfermedad")
    private Boolean tieneEnfermedad;

    @Column(name = "tiene_discapacidad")
    private Boolean tieneDiscapacidad;

    @Column(name = "usa_lentes")
    private Boolean usaLentes;

    @Column(name = "recibe_tratamiento")
    private Boolean recibeTramiento;

    @Column(name = "recibe_medicacion")
    private Boolean recibeMedicacion;

    @Column(name = "tratamiento")
    private String tratamiento;

    @Column(name = "observacion_habito_estudio")
    private String observacionHabitoEstudio;

    @Column(name = "observacion_lugar_estudio")
    private String observacionLugarEstudio;

    @Column(name = "observacion_distractores_estudio")
    private String observacionDistractoresEstudio;

    @Column(name = "otro_tratamiento")
    private String otroTratamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_cert_discapacidad")
    private Archivo archivoCertDiscapacidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_carne_discapacidad")
    private Archivo archivoCarneDiscapacidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tratamiento")
    private TipoTratamiento tipoTratamiento;

    @Transient
    private List<TipoApoyoActividad> tipoApoyoActividads;

    public HistoriaAntecedente() {
    }

    public HistoriaAntecedente(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Boolean getTuvoVacuna() {
        if (tuvoVacuna == null) {
            return false;
        }
        return tuvoVacuna;
    }

    public Boolean getTieneCarneDiscapacidad() {
        if (tieneCarneDiscapacidad == null) {
            return false;
        }
        return tieneCarneDiscapacidad;
    }

    public Boolean getTieneCertificadoDiscapacidad() {
        if (tieneCertificadoDiscapacidad == null) {
            return false;
        }
        return tieneCertificadoDiscapacidad;
    }

    public Boolean getTieneTratamiento() {
        if (tieneTratamiento == null) {
            return false;
        }
        return tieneTratamiento;
    }

    public Boolean getTieneOperacion() {
        if (tieneOperacion == null) {
            return false;
        }
        return tieneOperacion;
    }

    public Boolean getTieneFamiliarPsiquiatrico() {
        if (tieneFamiliarPsiquiatrico == null) {
            return false;
        }
        return tieneFamiliarPsiquiatrico;
    }

    public Boolean getTieneHabitoEstudio() {
        if (tieneHabitoEstudio == null) {
            return false;
        }
        return tieneHabitoEstudio;
    }

    public Boolean getTieneLugarEstudio() {
        if (tieneLugarEstudio == null) {
            return false;
        }
        return tieneLugarEstudio;
    }

    public Boolean getTieneAlergia() {
        if (tieneAlergia == null) {
            return false;
        }
        return tieneAlergia;
    }

    public Boolean getTieneEnfermedad() {
        if (tieneEnfermedad == null) {
            return false;
        }
        return tieneEnfermedad;
    }

    public Boolean getTieneDiscapacidad() {
        if (tieneDiscapacidad == null) {
            return false;
        }
        return tieneDiscapacidad;
    }

    public Boolean getRecibeTramiento() {
        if (recibeTramiento == null) {
            return false;
        }
        return recibeTramiento;
    }

    public Boolean getRecibeMedicacion() {
        if (recibeMedicacion == null) {
            return false;
        }
        return recibeMedicacion;
    }
    
    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", this.getClass().getSimpleName() + "{", "}");
        ModelUtils.getDataByAttr(join, "id", id);
        ModelUtils.getDataByAttr(join, "fueOperado", fueOperado, false);
        ModelUtils.getDataByAttr(join, "operacion", operacion, false);
        ModelUtils.getDataByAttr(join, "lugarOperacion", lugarOperacion, false);
        ModelUtils.getDataByAttr(join, "fechaOperacion", fechaOperacion, false);
        ModelUtils.getDataByAttr(join, "tomaMedicamento", tomaMedicamento, false);
        ModelUtils.getDataByAttr(join, "medicamento", medicamento, false);
        ModelUtils.getDataByAttr(join, "alergiasMedicamentosas", alergiasMedicamentosas, false);
        ModelUtils.getDataByAttr(join, "tuvoTratamientoPsicologico", tuvoTratamientoPsicologico, false);
        ModelUtils.getDataByAttr(join, "tuvoTratamientoPsiquiatrico", tuvoTratamientoPsiquiatrico, false);
        ModelUtils.getDataByAttr(join, "fechaPsicologico", fechaPsicologico, false);
        ModelUtils.getDataByAttr(join, "fechaPsiquiatrico", fechaPsiquiatrico, false);
        ModelUtils.getDataByAttr(join, "duracionTratamientoPsicologico", duracionTratamientoPsicologico, false);
        ModelUtils.getDataByAttr(join, "duracionTratamientoPsiquiatrico", duracionTratamientoPsiquiatrico, false);
        ModelUtils.getDataByAttr(join, "diagnosticoTratamientoPsiquiatrico", diagnosticoTratamientoPsiquiatrico, false);
        ModelUtils.getDataByAttr(join, "diagnosticoTratamientoPsicologico", diagnosticoTratamientoPsicologico, false);
        ModelUtils.getDataByAttr(join, "tuvoRubeola", tuvoRubeola, false);
        ModelUtils.getDataByAttr(join, "tuvoSarampion", tuvoSarampion, false);
        ModelUtils.getDataByAttr(join, "tuvoVaricela", tuvoVaricela, false);
        ModelUtils.getDataByAttr(join, "tuvoPaperas", tuvoPaperas, false);
        ModelUtils.getDataByAttr(join, "tuvoVacuna", tuvoVacuna, false);
        ModelUtils.getDataByAttr(join, "discapacidad", discapacidad, false);
        ModelUtils.getDataByAttr(join, "tieneCarneDiscapacidad", tieneCarneDiscapacidad, false);
        ModelUtils.getDataByAttr(join, "tieneCertificadoDiscapacidad", tieneCertificadoDiscapacidad, false);
        ModelUtils.getDataByAttr(join, "fechaRegistro", fechaRegistro, false);
        ModelUtils.getDataByAttr(join, "tieneTratamiento", tieneTratamiento, false);
        ModelUtils.getDataByAttr(join, "tieneOperacion", tieneOperacion, false);
        ModelUtils.getDataByAttr(join, "tieneFamiliarPsiquiatrico", tieneFamiliarPsiquiatrico, false);
        ModelUtils.getDataByAttr(join, "tieneHabitoEstudio", tieneHabitoEstudio, false);
        ModelUtils.getDataByAttr(join, "tieneLugarEstudio", tieneLugarEstudio, false);
        ModelUtils.getDataByAttr(join, "tieneAlergia", tieneAlergia, false);
        ModelUtils.getDataByAttr(join, "tieneEnfermedad", tieneEnfermedad, false);
        ModelUtils.getDataByAttr(join, "tieneDiscapacidad", tieneDiscapacidad, false);
        ModelUtils.getDataByAttr(join, "usaLentes", usaLentes, false);
        ModelUtils.getDataByAttr(join, "recibeTramiento", recibeTramiento, false);
        ModelUtils.getDataByAttr(join, "recibeMedicacion", recibeMedicacion, false);
        ModelUtils.getDataByAttr(join, "tratamiento", tratamiento, false);
        ModelUtils.getDataByAttr(join, "observacionHabitoEstudio", observacionHabitoEstudio, false);
        ModelUtils.getDataByAttr(join, "observacionLugarEstudio", observacionLugarEstudio, false);
        ModelUtils.getDataByAttr(join, "observacionDistractoresEstudio", observacionDistractoresEstudio, false);
        ModelUtils.getDataByAttr(join, "otroTratamiento", otroTratamiento, false);
        ModelUtils.getDataByAttrObject(join, "historiaClinica", historiaClinica, "id");
        ModelUtils.getDataByAttrObject(join, "archivoCertDiscapacidad", archivoCertDiscapacidad, "id", "ruta");
        ModelUtils.getDataByAttrObject(join, "archivoCarneDiscapacidad", archivoCarneDiscapacidad, "id", "ruta");
        ModelUtils.getDataByAttrObject(join, "tipoTratamiento", tipoTratamiento, "id", "descripcion");
        ModelUtils.getDataByAttrObject(join, "userRegistro", userRegistro, "id", "google");

        return join.toString();
    }

}

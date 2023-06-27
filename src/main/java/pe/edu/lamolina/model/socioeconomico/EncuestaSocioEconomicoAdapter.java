package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.Carrera;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.Facultad;
import pe.edu.lamolina.model.general.Colegio;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.Universidad;
import pe.edu.lamolina.model.inscripcion.Postulante;

public class EncuestaSocioEconomicoAdapter {

    private Persona persona;
    private Alumno alumno;
    private Postulante postulante;
    private CicloAcademico cicloAcademico;
    private Facultad facultad;
    private Carrera carrera;
    private Integer becaAlimento;
    private Colegio colegioProcedencia;
    private Universidad universidadProcedencia;
    private LugarResidencia lugarResidencia;
    private PersonaOcupacion personaOcupacion;
    private SituacionEconomica situacionEconomica;
    private BigDecimal ingresoFamiliarMensual;
    private PersonaVivienda personaVivienda;
    private Tenencia tenencia;
    private List<PersonaGastoFamilia> personaGastoFamilias;
    private ResideCon resideCon;
    private List<AbcDatosPersonaAdapter1234> familiares;
    private SeguroSalud seguroSalud;
    private ResumenSocioeconomico resumenSocioeconomico;
    private FichaSocioeconomica fichaSocioeconomica;
    private String observacionAsistente;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public CicloAcademico getCicloAcademico() {
        return cicloAcademico;
    }

    public void setCicloAcademico(CicloAcademico cicloAcademico) {
        this.cicloAcademico = cicloAcademico;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Integer getBecaAlimento() {
        return becaAlimento;
    }

    public void setBecaAlimento(Integer becaAlimento) {
        this.becaAlimento = becaAlimento;
    }

    public LugarResidencia getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(LugarResidencia lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public PersonaOcupacion getPersonaOcupacion() {
        return personaOcupacion;
    }

    public void setPersonaOcupacion(PersonaOcupacion personaOcupacion) {
        this.personaOcupacion = personaOcupacion;
    }

    public BigDecimal getIngresoFamiliarMensual() {
        return ingresoFamiliarMensual;
    }

    public void setIngresoFamiliarMensual(BigDecimal ingresoFamiliarMensual) {
        this.ingresoFamiliarMensual = ingresoFamiliarMensual;
    }

    public PersonaVivienda getPersonaVivienda() {
        return personaVivienda;
    }

    public void setPersonaVivienda(PersonaVivienda personaVivienda) {
        this.personaVivienda = personaVivienda;
    }

    public ResumenSocioeconomico getResumenSocioeconomico() {
        return resumenSocioeconomico;
    }

    public void setResumenSocioeconomico(ResumenSocioeconomico resumenSocioeconomico) {
        this.resumenSocioeconomico = resumenSocioeconomico;
    }

    public SituacionEconomica getSituacionEconomica() {
        return situacionEconomica;
    }

    public void setSituacionEconomica(SituacionEconomica situacionEconomica) {
        this.situacionEconomica = situacionEconomica;
    }

    public Colegio getColegioProcedencia() {
        return colegioProcedencia;
    }

    public void setColegioProcedencia(Colegio colegioProcedencia) {
        this.colegioProcedencia = colegioProcedencia;
    }

    public Universidad getUniversidadProcedencia() {
        return universidadProcedencia;
    }

    public void setUniversidadProcedencia(Universidad universidadProcedencia) {
        this.universidadProcedencia = universidadProcedencia;
    }

    public List<AbcDatosPersonaAdapter1234> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<AbcDatosPersonaAdapter1234> familiares) {
        this.familiares = familiares;
    }

    public String getObservacionAsistente() {
        return observacionAsistente;
    }

    public void setObservacionAsistente(String observacionAsistente) {
        this.observacionAsistente = observacionAsistente;
    }

    public Tenencia getTenencia() {
        return tenencia;
    }

    public void setTenencia(Tenencia tenencia) {
        this.tenencia = tenencia;
    }

    public ResideCon getResideCon() {
        return resideCon;
    }

    public void setResideCon(ResideCon resideCon) {
        this.resideCon = resideCon;
    }

    public SeguroSalud getSeguroSalud() {
        return seguroSalud;
    }

    public void setSeguroSalud(SeguroSalud seguroSalud) {
        this.seguroSalud = seguroSalud;
    }

    public List<PersonaGastoFamilia> getPersonaGastoFamilias() {
        return personaGastoFamilias;
    }

    public void setPersonaGastoFamilias(List<PersonaGastoFamilia> personaGastoFamilias) {
        this.personaGastoFamilias = personaGastoFamilias;
    }

    public FichaSocioeconomica getFichaSocioeconomica() {
        return fichaSocioeconomica;
    }

    public void setFichaSocioeconomica(FichaSocioeconomica fichaSocioeconomica) {
        this.fichaSocioeconomica = fichaSocioeconomica;
    }

    public ObjectNode toJson() {
        ArrayNode arrayFamilia = new ArrayNode(JsonNodeFactory.instance);
        List<AbcDatosPersonaAdapter1234> familiares = this.familiares == null ? new ArrayList<>() : this.familiares;
        for (AbcDatosPersonaAdapter1234 familiar : familiares) {
            arrayFamilia.add(familiar.toJson());
        }

        ObjectNode json2 = JsonHelper.createJson(this, JsonNodeFactory.instance,
                new String[]{
                    "*",
                    "persona.*",
                    "alumno.*",
                    "cicloAcademico.*",
                    "postulante.*",
                    "postulante.paisColegio.*",
                    "postulante.paisUniversidad.*",
                    "facultad.*",
                    "carrera.*",
                    "colegioProcedencia.*",
                    "colegioProcedencia.gestionDependencia.*",
                    "universidadProcedencia.*",
                    "universidadProcedencia.gestion.*",
                    "lugarResidencia.*",
                    "personaOcupacion.*",
                    "situacionEconomica.*",
                    "personaVivienda.*",
                    "tenencia.*",
                    "resideCon.*",
                    "personaGastoFamilias.*",
                    "personaGastoFamilias.persona.*",
                    "personaGastoFamilias.gastoFamilia.*",
                    "personaGastoFamilias.cicloAcademico.*",
                    "fichaSocioeconomica.*",
                    "seguroSalud.*",
                    "resumenSocioeconomico.*",});

        json2.set("familiares", arrayFamilia);

        return json2;

    }
}

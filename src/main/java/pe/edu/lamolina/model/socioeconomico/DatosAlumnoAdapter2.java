package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pe.albatross.zelpers.json.JaneHelper;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.academico.RecorridoIngresante;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.PersonaIdioma;
import pe.edu.lamolina.model.tramite.Tramite;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class DatosAlumnoAdapter2 implements Serializable {

    private Long id;

    private Alumno alumno;
    private CicloAcademico cicloAcademico;
    private Persona persona;
    private PersonaDomicilio personaDomicilio;
    private PersonaOcupacion personaOcupacion;
    private PersonaFamilia personaFamilia;
    private PersonaIdioma personaIdioma;
    private RecorridoIngresante recorrido;
    private ActividadDeporteCultura actividadDeporteCultura;
    private Tramite tramite;

    private List<PersonaEnfermedad> personaEnfermedad;
    private List<AntecedenteDeporteColegio> antecedenteDeporteColegio;
    private List<AntecedenteCulturalColegio> antecedenteCulturalColegio;
    private List<ActividadAlumnoLectura> actividadAlumnoLectura;
    private List<PersonaDocumento> personaDocumento;

    public Boolean getEsCachimbo() {
        if (this.recorrido == null) {
            return false;
        }
        return this.recorrido.getId() != null;
    }

    public ObjectNode toJson() {

        ArrayNode enfermedadesJson = JaneHelper
                .from(personaEnfermedad)
                .join("persona", "id")
                .join("cicloAcademico", "id")
                .array();

        ArrayNode antecedentesDeportesJson = JaneHelper
                .from(antecedenteDeporteColegio)
                .join("actividadDeporte")
                .join("alumno", "id")
                .array();

        ArrayNode antecedentesCulturalesJson = JaneHelper
                .from(antecedenteCulturalColegio)
                .join("actividadCultural")
                .join("alumno", "id")
                .array();

        ArrayNode lecturasAlumnoJson = JaneHelper
                .from(actividadAlumnoLectura)
                .join("tipoLibro")
                .join("alumno", "id")
                .array();

        ArrayNode documentosJson = new ArrayNode(JsonNodeFactory.instance);
        List<PersonaDocumento> docs = TypesUtil.getListNotNull(personaDocumento);

        for (PersonaDocumento documentoPersona : docs) {
            ObjectNode documentoPersonaJson = JaneHelper
                    .from(documentoPersona)
                    .join("documentoBienestar", "id,nombre")
                    .json();

            List<ArchivoPersonaDocumento> archivos = TypesUtil.getListNotNull(documentoPersona.getListaArchivosPersonaDocumento());
            ArrayNode archivosJson = JaneHelper
                    .from(archivos)
                    .join("archivo", "id,ruta")
                    .array();

            documentoPersonaJson.set("listaArchivosPersonaDocumento", archivosJson);
            documentosJson.add(documentoPersonaJson);
        }

        ObjectNode node = JaneHelper
                .from(this)
                .join("alumno", "id,codigo")
                .join("recorrido", "id")
                .join("tramite", "id")
                .join("cicloAcademico", "id,codigo,descripcion,descripcion2")
                .join("persona", "id,paterno,materno,nombres,apellidosNombres,numeroDocIdentidad,sexo,sexoEnum,edad,celular,email,telefono,fechaNacer,tipoFoto,rutaFoto,nombreCompleto,direccion")
                .join("persona.tipoDocumento", "id,simbolo,nombre")
                .join("persona.ubicacionNacer", "id,distrito")
                .join("persona.ubicacionDomicilio", "id,distrito")
                .join("persona.paisNacer", "id,nombre,nacionalidad,esPeru")
                .join("persona.paisDomicilio", "id,nombre,nacionalidad,esPeru")
                .join("persona.nacionalidad", "id,nombre,nacionalidad,esPeru")
                .join("persona.nacionalidad2", "id,nombre,nacionalidad,esPeru")
                .join("persona.estadoCivil")
                .join("persona.lenguaMaterna", "id,codigo,nombre")
                .join("personaDomicilio")
                .join("personaDomicilio.ubicacionLima", "id,distrito")
                .join("personaDomicilio.ubicacionLima.ubicacionSuperior", "id,codigo")
                .join("personaDomicilio.ubicacionOtro", "id,distrito")
                .join("personaDomicilio.ubicacionOtro.ubicacionSuperior", "id,codigo")
                .join("personaDomicilio.paisOtro", "id,nombre,nacionalidad,esPeru")
                .join("personaOcupacion", "id,rangoIngreso,rangoIngresoEnum,centroTrabajo,ingresoMensual,trabajoRealiza")
                .join("personaOcupacion.condicionTrabajo")
                .join("personaOcupacion.situacionEconomica")
                .join("personaOcupacion.profesion")
                .join("personaOcupacion.ocupacion")
                .join("personaIdioma")
                .join("personaFamilia", "id,estadoRelacionFamiliar,comentarioRelacionFamiliar")
                .join("personaFamilia.resideCon")
                .join("personaFamilia.estadoCivilPadres")
                .join("actividadDeporteCultura", "id,isCulturalUnalm,isDeporteUnalm,practicaActividad,practicaDeporteColegio,experienciaCulturalColegio,deporte,comentario")
                .join("actividadDeporteCultura.actividadCultural")
                .join("actividadDeporteCultura.deporteUnalm")
                .join("actividadDeporteCultura.culturalUnalm")
                .join("actividadDeporteCultura.alumno", "id")
                .json();

        node.set("personaEnfermedad", enfermedadesJson);
        node.set("antecedenteDeporteColegio", antecedentesDeportesJson);
        node.set("antecedenteCulturalColegio", antecedentesCulturalesJson);
        node.set("actividadAlumnoLectura", lecturasAlumnoJson);
        node.set("personaDocumento", documentosJson);

        return node;
    }

}

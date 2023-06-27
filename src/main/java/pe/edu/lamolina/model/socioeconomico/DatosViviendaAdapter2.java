package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.json.JaneHelper;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.tramite.Tramite;

@Getter
@Setter
public class DatosViviendaAdapter2 implements Serializable {

    private Alumno alumno;
    private Persona persona;
    private CicloAcademico cicloAcademico;
    private PersonaVivienda personaVivienda;
    private PersonaDomicilio personaDomicilio;
    private Tramite tramite;

    public ObjectNode toJson() {
        return JaneHelper
                .from(this)
                .join("alumno", "id")
                .join("persona", "id")
                .join("cicloAcademico", "id,codigo")
                .join("personaVivienda")
                .join("personaVivienda.materialVivienda")
                .join("personaVivienda.condicionVivienda")
                .join("personaVivienda.tenencia")
                .join("personaVivienda.tipoVivienda")
                .join("personaVivienda.servicioAgua")
                .join("personaVivienda.desague")
                .join("personaVivienda.lugarResidencia")
                .join("personaDomicilio")
                .join("personaDomicilio.ubicacionLima", "id,distrito")
                .join("personaDomicilio.ubicacionLima.ubicacionSuperior", "id,codigo")
                .join("personaDomicilio.ubicacionOtro", "id,distrito")
                .join("personaDomicilio.ubicacionOtro.ubicacionSuperior", "id,codigo")
                .join("personaDomicilio.paisOtro", "id,nombre,nacionalidad,esPeru")
                .join("personaDomicilio.fotoFachadaDomicilioLima", "id,ruta")
                .join("personaDomicilio.fotoFachadaDomicilioOtro", "id,ruta")
                .json();
    }

}

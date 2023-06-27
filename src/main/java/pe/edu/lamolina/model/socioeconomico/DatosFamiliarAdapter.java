package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.json.JaneHelper;
import pe.edu.lamolina.model.academico.Alumno;
import pe.edu.lamolina.model.academico.CicloAcademico;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.tramite.Tramite;

@Getter
@Setter
@NoArgsConstructor
public class DatosFamiliarAdapter implements Serializable {

    private Alumno alumno;
    private Persona persona;
    private CicloAcademico cicloAcademico;
    private Persona personaVinculada;
    private PersonaVinculoFamiliar informacionVinculoFamiliar;
    private PersonaOcupacion personaOcupacion;
    private VinculoFamiliar vinculoFamiliar;
    private List<PersonaEnfermedad> personaEnfermedad;
    private Tramite tramite;

    public DatosFamiliarAdapter(Boolean crearVacios) {
        if (crearVacios) {
            this.persona = new Persona();
            this.cicloAcademico = new CicloAcademico();
            this.informacionVinculoFamiliar = new PersonaVinculoFamiliar();
            this.personaOcupacion = new PersonaOcupacion();
            this.vinculoFamiliar = new VinculoFamiliar();
            this.personaEnfermedad = new ArrayList();
        }
    }

    public ObjectNode toJson() {
        ArrayNode enfermedadesJson = new ArrayNode(JsonNodeFactory.instance);
        if (personaEnfermedad != null && !personaEnfermedad.isEmpty()) {
            enfermedadesJson.add(JaneHelper
                    .from(personaEnfermedad)
                    .array());
        }

        ObjectNode node = JaneHelper
                .from(this)
                .join("persona", "id")
                .join("cicloAcademico", "id")
                .join("vinculoFamiliar")
                .join("informacionVinculoFamiliar")
                .join("personaVinculada", "id,numeroDocIdentidad,apellidosNombres,nombreCompleto,paterno,materno,nombres,sexo,fechaNacer,edad,email,telefono,celular,estadoValidacion")
                .join("personaVinculada.estadoCivil")
                .join("personaVinculada.tipoDocumento", "id,simbolo,nombre")
                .join("personaOcupacion")
                .join("personaOcupacion.condicionTrabajo")
                .join("personaOcupacion.ocupacion")
                .join("personaOcupacion.profesion")
                .join("personaOcupacion.gradoInstruccion")
                .join("personaOcupacion.persona", "id")
                .join("personaOcupacion.cicloAcademico", "id")
                .json();

        node.set("personaEnfermedad", enfermedadesJson);

        return node;
    }
}

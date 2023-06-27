package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.JsonHelper;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.general.PersonaEtnia;
import pe.edu.lamolina.model.general.PersonaReligion;
import pe.edu.lamolina.model.medico.HistoriaDificultadPermanente;

@Getter
@Setter
public class DatosOtrosAdapter {

    private Persona persona;
    private PersonaReligion personaReligion;
    private PersonaEtnia personaEtnia;
    private List<HistoriaDificultadPermanente> dificultades;

    public ObjectNode toJson() {
        return JsonHelper.createJson(this, JsonNodeFactory.instance, new String[]{
            "persona.id",
            "personaReligion.*",
            "personaReligion.cicloAcademico.id",
            "personaReligion.persona.id",
            "personaReligion.religion.*",
            "personaEtnia.*",
            "personaEtnia.persona.id",
            "personaEtnia.etnia.*",
            "dificultades.*",
            "dificultades.dificultadPermanente.*",
            "dificultades.persona.id",
            "dificultades.cicloAcademico.id"
        });
    }
}

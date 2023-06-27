package pe.edu.lamolina.model.socioeconomico;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pe.edu.lamolina.model.bienestar.DocumentoBienestar;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
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
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.general.Persona;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Entity
@Getter
@Setter
@Table(name = "isec_persona_documento")
public class PersonaDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "entregado")
    private Boolean entregado;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_entregado")
    @JsonDeserialize(using = DateTimeDeserializer.class)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaEntregado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_bienestar")
    private DocumentoBienestar documentoBienestar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_entregado")
    private Usuario userEntregado;

    @OneToMany(mappedBy = "personaDocumento", fetch = FetchType.LAZY)
    private List<ArchivoPersonaDocumento> listaArchivosPersonaDocumento;

    public PersonaDocumento() {
    }

    public PersonaDocumento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public static class CompareNombre implements Comparator<PersonaDocumento> {

        @Override
        public int compare(PersonaDocumento s1, PersonaDocumento s2) {
            return s1.getDocumentoBienestar().getNombre().compareTo(s2.getDocumentoBienestar().getNombre());
        }
    }

}

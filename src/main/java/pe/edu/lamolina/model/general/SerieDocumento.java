package pe.edu.lamolina.model.general;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.seguridad.Usuario;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "gen_serie_documento")
public class SerieDocumento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento_compania")
    private TipoDocumentoCompania tipoDocumentoCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    public SerieDocumento(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public SerieDocumento(TipoDocumentoCompania tipo, String serie) {
        this.tipoDocumentoCompania = tipo;
        this.numeroSerie = serie;
    }

}

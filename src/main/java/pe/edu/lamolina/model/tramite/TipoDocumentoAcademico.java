package pe.edu.lamolina.model.tramite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.TipoConstanciaEnum;
import pe.edu.lamolina.model.enums.TipoDocumentoAcademicoEnum;
import pe.edu.lamolina.model.general.Oficina;

@Getter
@Setter
@Entity
@Table(name = "tram_tipo_documento_academico")
public class TipoDocumentoAcademico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "costo_ciclo")
    private Long costoCiclo;

    @Column(name = "configurado")
    private Long configurado;

    @Column(name = "requiere_foto")
    private Integer requiereFoto;

    @Column(name = "requiere_egresado")
    private Integer requiereEgresado;

    @Column(name = "requiere_posgrado")
    private Integer requierePosgrado;

    @Column(name = "requiere_pregrado")
    private Integer requierePregrado;

    @Column(name = "plazo_dias_pago")
    private Integer plazoDiasPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina_emisora")
    private Oficina oficinaEmisora;

    @Transient
    private List<TramiteDocumentoAcademico> tramiteDocumentoAcademico;
    @Transient
    private List<PlantillaDocumentoAcademico> plantillaDocumentoAcademico;
    @Transient
    private List<ConfiguracionFirmaDocumento> configuracionFirmaDocumento;
    @Transient
    private List<PrecioDocumento> precioDocumento;

    public TipoDocumentoAcademico() {
    }

    public TipoDocumentoAcademico(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public TipoConstanciaEnum getTipoConstanciaEnum() {
        if (StringUtils.isBlank(this.tipo)) {
            return null;
        }
        return TipoConstanciaEnum.valueOf(tipo);
    }

    @JsonIgnore
    public void setTipoConstanciaEnum(TipoConstanciaEnum tipo) {
        this.tipo = tipo.name();
    }

    public TipoDocumentoAcademicoEnum getCodigoDocumentoEnum() {
        if (StringUtils.isBlank(this.codigo)) {
            return null;
        }
        return TipoDocumentoAcademicoEnum.valueOf(codigo);
    }

    @JsonIgnore
    public void setCodigoDocumentoEnum(TipoDocumentoAcademicoEnum tipoEnum) {
        this.codigo = tipoEnum.name();
    }

}

package pe.edu.lamolina.model.general;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.posgrado.empresa.RubroEPG;
import pe.edu.lamolina.model.zzerializator.DateTimeDeserializer;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "gen_empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Column(name = "numero_doc_identidad")
    private String numeroDocIdentidad;

    @Column(name = "ruta_icono")
    private String rutaIcono;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "website")
    private String website;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "logo")
    private String logo;

    @Column(name = "tipo_empresa")
    private String tipoEmpresa;

    @Column(name = "otros_ambitos")
    private String otrosAmbitos;

    @Column(name = "empleados")
    private String empleados;

    @Column(name = "estado_networking")
    private String estadoNetworking;

    @Column(name = "actualizado")
    private Integer actualizado;

    @Column(name = "celular")
    private String celular;

    @Column(name = "ip_registro")
    private String ipRegistro;

    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais_ubicacion")
    private Pais paisUbicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_doc_identidad")
    private TipoDocIdentidad tipoDocIdentidad;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    private List<RubroEmpresa> rubroEmpresa;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    private List<GiroEmpresa> giroEmpresa;

    @Transient
    private String iconoImagen;
    @Transient
    private Integer logoUpdate;
    @Transient
    private ContactoEmpresa contactoEmpresaMain;
    @Transient
    private EmpresaCuentaBancaria cuentaBancariaMain;
    @Transient
    private List<RubroEPG> rubrosEPG;

    public Empresa(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public List<RubroEmpresa> getRubroEmpresa() {
        if (rubroEmpresa == null) {
            return new ArrayList();
        }
        return rubroEmpresa;
    }

    public String getNombreComercial() {
        if (StringUtils.isBlank(nombreComercial)) {
            return razonSocial;
        }
        return nombreComercial;
    }

    public List<RubroEPG> getRubrosEPG() {
        if (rubrosEPG == null) {
            return new ArrayList();
        }

        return rubrosEPG;
    }

    public Boolean getTieneDireccion() {
        if (this.direccion == null) {
            return Boolean.FALSE;
        }
        return !StringUtils.isBlank(this.direccion.trim());
    }

}

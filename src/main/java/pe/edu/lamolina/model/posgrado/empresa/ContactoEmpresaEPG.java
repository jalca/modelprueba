package pe.edu.lamolina.model.posgrado.empresa;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.io.Serializable;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import pe.edu.lamolina.model.general.Empresa;

@Getter
@Setter
@Entity
@Table(catalog = "lamolina", name = "epg_contacto_empresa")
public class ContactoEmpresaEPG implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "correo")
    private String correo;

    @Column(name = "celular")
    private String celular;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public ContactoEmpresaEPG() {
    }

    public ContactoEmpresaEPG(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getApellidosNombres() {
        return apellidos + " " + nombres;
    }

}

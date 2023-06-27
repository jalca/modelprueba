package pe.edu.lamolina.model.finanzas;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.aporte.AporteAlumnoCiclo;
import pe.edu.lamolina.model.enums.CuentaBancariaEnum;
import pe.edu.lamolina.model.general.Compania;
import pe.edu.lamolina.model.general.Oficina;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "fin_cuenta_bancaria")
public class CuentaBancaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "numero_cci")
    private String numeroCCI;

    @Column(name = "proyecto_fda")
    private String proyectoFda;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "serie_boleta")
    private String serieBoleta;

    @Column(name = "serie_factura")
    private String serieFactura;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "banco")
    private String banco;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compania")
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oficina")
    private Oficina oficina;

    @OneToMany(mappedBy = "cuentaBancaria", fetch = FetchType.LAZY)
    private List<CargaAbonos> cargaAbonos;

    @OneToMany(mappedBy = "cuentaBancaria", fetch = FetchType.LAZY)
    private List<ConceptoPago> conceptoPago;

    @Transient
    private List<AporteAlumnoCiclo> aportesAlumnosCiclos;

    public CuentaBancaria(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public String getCuentaDescripcion() {
        return numero.concat(" - ").concat(nombre);
    }

    public boolean isAdmisionUnalm() {

        if (CuentaBancariaEnum.INS_UNLM.getCodigoServ().equals(this.getCodigo())
                || CuentaBancariaEnum.GUIA_POST.getCodigoServ().equals(this.getCodigo())) {
            return true;
        }

        return false;
    }

    public boolean isAdmisionPosgrado() {

        if (CuentaBancariaEnum.ADM_EPG.getCodigoServ().equals(this.getCodigo())) {
            return true;
        }

        return false;
    }

    public boolean isMatriculaUnalm() {
        if (CuentaBancariaEnum.MAT_UNALM.getCodigoServ().equals(this.getCodigo())
                || CuentaBancariaEnum.MAT_FDA.getCodigoServ().equals(this.getCodigo())) {
            return true;
        }

        return false;
    }

    public boolean isFdaCursos() {
        if (CuentaBancariaEnum.FDA_CURSOS.getCodigoServ().equals(this.getCodigo())) {
            return true;
        }

        return false;
    }

    public boolean isFdaCursosEPg() {
        if (CuentaBancariaEnum.EPG_TRAM_GRADO.getCodigoServ().equals(this.getCodigo())) {
            return true;
        }

        return false;
    }

    public boolean isConceptosPosgrado() {

        if (CuentaBancariaEnum.CUENTA_POSGRADO_UNALM.getCodigoServ().equals(this.getCodigo())) {
            return true;
        }
        if (CuentaBancariaEnum.CUENTA_POSGRADO_FDA.getCodigoServ().equals(this.getCodigo())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CuentaBancaria)) {
            return false;
        }
        
        CuentaBancaria other = (CuentaBancaria) obj;
        if (this.id == null && other.getId() == null) {
            return true;
        }

        if ((this.id == null && other.getId() != null)
                || (this.id != null && other.getId() == null)
                || (this.id.compareTo(other.getId()) != 0)) {
            return false;
        }
        return true;
    }

}

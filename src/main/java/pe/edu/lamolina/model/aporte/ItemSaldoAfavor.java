package pe.edu.lamolina.model.aporte;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import pe.albatross.zelpers.miscelanea.TypesUtil;
import pe.edu.lamolina.model.enums.EstadoEnum;
import pe.edu.lamolina.model.enums.InstanciaEnum;
import pe.edu.lamolina.model.enums.OrigenItemSaldoAfavorEnum;
import pe.edu.lamolina.model.enums.TipoMovimientoEnum;
import pe.edu.lamolina.model.finanzas.PagoConceptoSaldoAfavor;
import pe.edu.lamolina.model.general.Archivo;
import pe.edu.lamolina.model.posgrado.AlumnoCuotaMatricula;
import pe.edu.lamolina.model.seguridad.Usuario;
import pe.edu.lamolina.model.zzerializator.DateDeserializer;

@Entity
@Table(name = "fin_item_saldo_afavor")
public class ItemSaldoAfavor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "utilizado")
    private BigDecimal utilizado;

    @Column(name = "disponible")
    private BigDecimal disponible;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "origen")
    private String origen;

    @Column(name = "tabla")
    private String tabla;

    @Column(name = "instancia")
    private Long instancia;

    @Column(name = "banco_origen")
    private String bancoOrigen;

    @Column(name = "numero_operacion")
    private String numeroOperacion;

    @Column(name = "fecha_operacion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaOperacion;

    @Column(name = "fecha_registro")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "fecha_anulacion")
    @JsonDeserialize(using = DateDeserializer.class)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_saldo_afavor_alumno")
    private SaldoAfavorAlumno saldoAfavorAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_origen_item_saldo_afavor")
    private ItemSaldoAfavor origenItemSaldoAfavor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_archivo_operacion")
    private Archivo archivoOperacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_registro")
    private Usuario userRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_anulacion")
    private Usuario userAnulacion;

    @OneToMany(mappedBy = "itemSaldoAfavor", fetch = FetchType.LAZY)
    private List<AporteAlumnoCiclo> aporteAlumnoCiclo;

    @OneToMany(mappedBy = "itemSaldoAfavor", fetch = FetchType.LAZY)
    private List<PagoConceptoSaldoAfavor> pagosConceptosSaldosAfavor;

    @OneToMany(mappedBy = "itemSaldoAfavor", fetch = FetchType.LAZY)
    private List<AlumnoCuotaMatricula> alumnoCuotasMatriculas;

    @OneToMany(mappedBy = "origenItemSaldoAfavor", fetch = FetchType.LAZY)
    private List<ItemSaldoAfavor> itemsSaldosAfavorDestinos;

    @Transient
    private String rutaimagen;

    @Transient
    private String tipoimagen;

    public ItemSaldoAfavor() {
        this.utilizado = BigDecimal.ZERO;
        this.disponible = BigDecimal.ZERO;
        this.estado = EstadoEnum.ACT.name();
    }

    public ItemSaldoAfavor(Object id) {
        this.id = TypesUtil.getLong(id);
        this.utilizado = BigDecimal.ZERO;
        this.disponible = BigDecimal.ZERO;
        this.estado = EstadoEnum.ACT.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public TipoMovimientoEnum getTipoEnum() {
        if (tipo == null) {
            return null;
        }
        return TipoMovimientoEnum.valueOf(tipo);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonIgnore
    public void setTipoEnum(TipoMovimientoEnum tipo) {
        if (tipo == null) {
            return;
        }
        this.tipo = tipo.name();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public SaldoAfavorAlumno getSaldoAfavorAlumno() {
        return saldoAfavorAlumno;
    }

    public void setSaldoAfavorAlumno(SaldoAfavorAlumno saldoAfavorAlumno) {
        this.saldoAfavorAlumno = saldoAfavorAlumno;
    }

    public Usuario getUserRegistro() {
        return userRegistro;
    }

    public void setUserRegistro(Usuario userRegistro) {
        this.userRegistro = userRegistro;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @JsonIgnore
    public void setOrigenEnum(OrigenItemSaldoAfavorEnum origen) {
        if (origen == null) {
            return;
        }
        this.origen = origen.name();
    }

    public OrigenItemSaldoAfavorEnum getOrigenEnum() {
        if (this.origen == null) {
            return null;
        }
        return OrigenItemSaldoAfavorEnum.get(this.origen);
    }

    public List<AporteAlumnoCiclo> getAporteAlumnoCiclo() {
        return aporteAlumnoCiclo;
    }

    public void setAporteAlumnoCiclo(List<AporteAlumnoCiclo> aporteAlumnoCiclo) {
        this.aporteAlumnoCiclo = aporteAlumnoCiclo;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public String getBancoOrigen() {
        return bancoOrigen;
    }

    public void setBancoOrigen(String bancoOrigen) {
        this.bancoOrigen = bancoOrigen;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public Long getInstancia() {
        return instancia;
    }

    public void setInstancia(Long instancia) {
        this.instancia = instancia;
    }

    public InstanciaEnum getTablaEnum() {
        if (StringUtils.isBlank(this.tabla)) {
            return null;
        }
        return InstanciaEnum.valueOf(this.tabla);
    }

    @JsonIgnore
    public void setTablaEnum(InstanciaEnum tablaEnum) {
        if (tablaEnum != null) {
            this.tabla = tablaEnum.name();
        }
    }

    public String getRutaimagen() {
        return rutaimagen;
    }

    public void setRutaimagen(String rutaimagen) {
        this.rutaimagen = rutaimagen;
    }

    public String getTipoimagen() {
        return tipoimagen;
    }

    public void setTipoimagen(String tipoimagen) {
        this.tipoimagen = tipoimagen;
    }

    public BigDecimal getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(BigDecimal utilizado) {
        this.utilizado = utilizado;
    }

    public BigDecimal getDisponible() {
        return disponible;
    }

    public void setDisponible(BigDecimal disponible) {
        this.disponible = disponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EstadoEnum getEstadoEnum() {
        if (estado == null) {
            return null;
        }
        return EstadoEnum.valueOf(estado);
    }

    @JsonIgnore
    public void setEstadoEnum(EstadoEnum estado) {
        if (estado == null) {
            return;
        }
        this.estado = estado.name();
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Usuario getUserAnulacion() {
        return userAnulacion;
    }

    public void setUserAnulacion(Usuario userAnulacion) {
        this.userAnulacion = userAnulacion;
    }

    public ItemSaldoAfavor getOrigenItemSaldoAfavor() {
        return origenItemSaldoAfavor;
    }

    public void setOrigenItemSaldoAfavor(ItemSaldoAfavor origenItemSaldoAfavor) {
        this.origenItemSaldoAfavor = origenItemSaldoAfavor;
    }

    public Archivo getArchivoOperacion() {
        return archivoOperacion;
    }

    public void setArchivoOperacion(Archivo archivoOperacion) {
        this.archivoOperacion = archivoOperacion;
    }

    public List<PagoConceptoSaldoAfavor> getPagosConceptosSaldosAfavor() {
        return pagosConceptosSaldosAfavor;
    }

    public void setPagosConceptosSaldosAfavor(List<PagoConceptoSaldoAfavor> pagosConceptosSaldosAfavor) {
        this.pagosConceptosSaldosAfavor = pagosConceptosSaldosAfavor;
    }

    public List<AlumnoCuotaMatricula> getAlumnoCuotasMatriculas() {
        return alumnoCuotasMatriculas;
    }

    public void setAlumnoCuotasMatriculas(List<AlumnoCuotaMatricula> alumnoCuotasMatriculas) {
        this.alumnoCuotasMatriculas = alumnoCuotasMatriculas;
    }

    public List<ItemSaldoAfavor> getItemsSaldosAfavorDestinos() {
        return itemsSaldosAfavorDestinos;
    }

    public void setItemsSaldosAfavorDestinos(List<ItemSaldoAfavor> itemsSaldosAfavorDestinos) {
        this.itemsSaldosAfavorDestinos = itemsSaldosAfavorDestinos;
    }

    public static class CompareByIdAsc implements Comparator<ItemSaldoAfavor> {

        @Override
        public int compare(ItemSaldoAfavor item1, ItemSaldoAfavor item2) {
            return item1.getId().compareTo(item2.getId());
        }
    }

    public static class CompareByFechaOperacionIdAsc implements Comparator<ItemSaldoAfavor> {

        @Override
        public int compare(ItemSaldoAfavor item1, ItemSaldoAfavor item2) {
            if (item1.getFechaOperacion() != null && item2.getFechaOperacion() != null) {
                return item1.getFechaOperacion().compareTo(item2.getFechaOperacion());
            }
            if (item1.getFechaOperacion() != null && item2.getFechaOperacion() == null) {
                return -1;
            }
            if (item1.getFechaOperacion() == null && item2.getFechaOperacion() != null) {
                return 1;
            }
            return item1.getId().compareTo(item2.getId());
        }
    }

    public static class CompareByFechaOperacionIdDesc implements Comparator<ItemSaldoAfavor> {

        @Override
        public int compare(ItemSaldoAfavor item1, ItemSaldoAfavor item2) {
            if (item2.getFechaOperacion() != null && item1.getFechaOperacion() != null) {
                return item2.getFechaOperacion().compareTo(item1.getFechaOperacion());
            }
            if (item2.getFechaOperacion() != null && item1.getFechaOperacion() == null) {
                return -1;
            }
            if (item2.getFechaOperacion() == null && item1.getFechaOperacion() != null) {
                return 1;
            }
            return item2.getId().compareTo(item1.getId());
        }
    }

}

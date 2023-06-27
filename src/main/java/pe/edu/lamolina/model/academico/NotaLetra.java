package pe.edu.lamolina.model.academico;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pe.albatross.zelpers.miscelanea.TypesUtil;

@Entity
@Table(name = "aca_nota_letra")
public class NotaLetra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "letra")
    private String letra;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "es_aprobatorio")
    private Integer esAprobatorio;

    @Column(name = "valor")
    private Integer valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sistema_notas")
    private SistemaNotas sistemaNotas;

    public NotaLetra() {
    }

    public NotaLetra(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SistemaNotas getSistemaNotas() {
        return sistemaNotas;
    }

    public void setSistemaNotas(SistemaNotas sistemaNotas) {
        this.sistemaNotas = sistemaNotas;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getEsAprobatorio() {
        return esAprobatorio;
    }

    public void setEsAprobatorio(Integer esAprobatorio) {
        this.esAprobatorio = esAprobatorio;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAprobatorio() {
        if (BigDecimal.ONE.intValue() == this.esAprobatorio) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "NotaLetra{" + "id=" + id + ", letra=" + letra + ", esAprobatorio=" + esAprobatorio + ", valor=" + valor + '}';
    }

}

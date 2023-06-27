package pe.edu.lamolina.model.medico;

import java.io.Serializable;
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
@Table(name = "med_pieza_dental_superficie")
public class PiezaDentalSuperficie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "superficie")
    private Integer superficie;

    @Column(name = "carie_imagen")
    private String carieImagen;

    @Column(name = "restauracion_imagen")
    private String restauracionImagen;

    @Column(name = "restauracion_parcial_imagen")
    private String restauracionParcialImagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pieza_dental")
    private PiezaDental piezaDental;

    public PiezaDentalSuperficie() {
    }

    public PiezaDentalSuperficie(Object id) {
        this.id = TypesUtil.getLong(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PiezaDental getPiezaDental() {
        return piezaDental;
    }

    public void setPiezaDental(PiezaDental piezaDental) {
        this.piezaDental = piezaDental;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public String getCarieImagen() {
        return carieImagen;
    }

    public void setCarieImagen(String carieImagen) {
        this.carieImagen = carieImagen;
    }

    public String getRestauracionImagen() {
        return restauracionImagen;
    }

    public void setRestauracionImagen(String restauracionImagen) {
        this.restauracionImagen = restauracionImagen;
    }

    public String getRestauracionParcialImagen() {
        return restauracionParcialImagen;
    }

    public void setRestauracionParcialImagen(String restauracionParcialImagen) {
        this.restauracionParcialImagen = restauracionParcialImagen;
    }

}

package pe.edu.lamolina.model.tramite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tram_tipo_observacion_proyecto_tesis")
public class TipoObservacionProyectoTesis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_archivo")
    private Boolean tipoArchivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(Boolean tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

}

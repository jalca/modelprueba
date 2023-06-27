package pe.edu.lamolina.model.atencion;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "atc_categoria_ticket_ayuda")
public class CategoriaTicketAyuda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "categoriaTicketAyuda", fetch = FetchType.LAZY)
    private List<TicketAyuda> ticketAyudas;

    public CategoriaTicketAyuda(Long id) {
        this.id = id;
    }

}

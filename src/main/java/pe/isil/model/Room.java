package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_room")
public class Room {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_room")
    private int idRoom;

    @Column(name = "type_room", length = 40)
    private String typeRoom;

    @Column(name = "desc_room", length = 100)
    private String descRoom;

    @Column(name = "price_room",length = 60)
    private Double priceRoom;

    @Column(name = "quantity_room")
    private int quantityRoom;

    @OneToOne(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Reservation reservation;

}

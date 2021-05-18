package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_reservation")
public class Reservation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reservation")
    private int idReservation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "check_in")
    private LocalDate checkIn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "check_out")
    private LocalDate checkOut;

    @Column(name = "quantity_guest")
    private int quantityGuest;

    @Column(name = "id_room")
    private int idRoom;

    @Column(name = "id_user")
    private int idUser;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_room", insertable = false, updatable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

}

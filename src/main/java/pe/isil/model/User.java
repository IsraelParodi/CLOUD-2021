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
@Table(name = "tbl_user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private int idUser;

    @Column(length = 40)
    private String nameUser;

    @Column(name = "lastname_user",length = 40)
    private String lastNameUser;

    @Column(name = "typedoc_user", length = 40)
    private String typeDocUser;

    @Column(name = "numdoc_user", length = 16)
    private String numDocUser;

    @Column(name = "email_user",length = 60)
    private String emailUser;

    @Column(name = "pass_user",length = 40)
    private String passUser;

    @Column(name = "type_user")
    private Boolean typeUser;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations;

}

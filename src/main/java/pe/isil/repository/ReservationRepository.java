package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}

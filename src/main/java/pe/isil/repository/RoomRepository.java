package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}

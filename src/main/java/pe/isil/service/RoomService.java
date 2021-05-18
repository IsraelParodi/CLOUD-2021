package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Room;
import pe.isil.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements BaseService<Room, Integer>{

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Optional<Room> findById(Integer id) {
        return roomRepository.findById(id);
    }

    @Override
    public Optional<List<Room>> findAll() {
        return Optional.of(roomRepository.findAll());
    }

    @Override
    public Room saveOrUpdate(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public boolean deleteById(Integer id) {
        return findById(id)
                .map(room -> {
                    roomRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}

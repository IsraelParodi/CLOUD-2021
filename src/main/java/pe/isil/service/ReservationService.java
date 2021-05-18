package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Reservation;
import pe.isil.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements BaseService<Reservation, Integer>{

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Optional<Reservation> findById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Optional<List<Reservation>> findAll() {
        return Optional.of(reservationRepository.findAll());
    }

    @Override
    public Reservation saveOrUpdate(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public boolean deleteById(Integer id) {
        return findById(id)
                .map(reservation -> {
                    reservationRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}

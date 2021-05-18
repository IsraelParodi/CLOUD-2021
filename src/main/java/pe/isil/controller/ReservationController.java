package pe.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Reservation;
import pe.isil.service.ReservationService;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public String reservation(Model model){

        reservationService.findAll()
                .ifPresent(reservations -> model.addAttribute("reservations", reservations));

        return "reservation";
    }

    @GetMapping("/reservations/add")
    public String reservationAdd(Model model){
        model.addAttribute("reservation", new Reservation());
        return "reservation-add";
    }

    @PostMapping("/reservations/save")
    public String reservationsSave(Reservation reservation){
        reservationService.saveOrUpdate(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/edit/{id}")
    public String reservationsEdit(@PathVariable int id, Model model){

        reservationService.findById(id)
                .ifPresent(reservation -> model.addAttribute("reservation", reservation));

        return "reservation-add";
    }

    @GetMapping("/reservations/delete/{id}")
    public String reservationsDelete(@PathVariable int id, Model model){

        reservationService.deleteById(id);

        return "redirect:/reservations";
    }

}

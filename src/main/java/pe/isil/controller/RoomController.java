package pe.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Room;
import pe.isil.model.User;
import pe.isil.service.RoomService;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String rooms(Model model){

        roomService.findAll()
                .ifPresent(rooms -> model.addAttribute("rooms", rooms));

        return "room";
    }

    @GetMapping("/rooms/add")
    public String roomAdd(Model model){
        model.addAttribute("room", new Room());
        return "room-add";
    }

    @PostMapping("/rooms/save")
    public String roomsSave(Room room){
        roomService.saveOrUpdate(room);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms/edit/{id}")
    public String roomsEdit(@PathVariable int id, Model model){

        roomService.findById(id)
                .ifPresent(room -> model.addAttribute("room", room));

        return "room-add";
    }

    @GetMapping("/rooms/delete/{id}")
    public String roomsDelete(@PathVariable int id, Model model){

        roomService.deleteById(id);

        return "redirect:/rooms";
    }

}

package pe.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.User;
import pe.isil.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String users(Model model){

        userService.findAll()
                .ifPresent(users -> model.addAttribute("users", users));

        return "user";
    }

    @GetMapping("/users/add")
    public String usersAdd(Model model){
        model.addAttribute("user", new User());
        return "user-add";
    }

    @PostMapping("/users/save")
    public String usersSave(User user){
        userService.saveOrUpdate(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String usersEdit(@PathVariable int id, Model model){

        userService.findById(id)
                .ifPresent(user -> model.addAttribute("user", user));

        return "user-add";
    }

    @GetMapping("/users/delete/{id}")
    public String usersDelete(@PathVariable int id, Model model){

        userService.deleteById(id);

        return "redirect:/users";
    }

}
